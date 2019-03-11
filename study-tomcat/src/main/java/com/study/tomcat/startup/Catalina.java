package com.study.tomcat.startup;

import com.study.tomcat.common.PropertyConstants;
import com.study.tomcat.server.Server;

import org.apache.commons.digester.Digester;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.security.Security;

/**
 * Catalina类用来启动和停止一个Server，并解析Tomcat配置文件server.xml
 *
 * @author dranawhite
 * @version $Id: Catalina.java, v 0.1 2019-03-09 14:05 dranawhite Exp $$
 */
public class Catalina {

    /**
     * server.xml配置文件
     */
    private String configFile = "conf/server.xml";

    /**
     * Digester debug模式
     */
    private boolean debug = false;

    private boolean starting = false;
    private boolean stopping = false;

    /**
     * 是否使用JNDI服务
     */
    private boolean useNaming = true;


    /**
     * Catalina入口方法
     *
     * @param args 命令行参数
     */
    public void process(String[] args) {
        // 设置catalina.home和catalina.base系统变量
        setCatalinaHome();
        setCatalinaBase();
        try {
            if (arguments(args)) {
                execute();
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    /**
     * 设置<code>catalina.home</code>系统属性
     * <pre>
     *     若用户没有设置catalina.home系统变量，则将catalina.home设置为当前用户工作空间
     * </pre>
     */
    private void setCatalinaHome() {
        if (System.getProperty(PropertyConstants.CATALINA_HOME) != null) {
            return;
        }
        System.setProperty(PropertyConstants.CATALINA_HOME, System.getProperty("user.dir"));
    }

    /**
     * 设置<code>catalina.base</code>系统属性
     * <pre>
     *     若用户没有设置catalina.base系统变量，则将catalina.base设置为catalina.home
     * </pre>
     */
    private void setCatalinaBase() {
        if (System.getProperty(PropertyConstants.CATALINA_BASE) != null) {
            return;
        }
        System.setProperty(PropertyConstants.CATALINA_BASE, System.getProperty(PropertyConstants.CATALINA_HOME));
    }

    /**
     * 处理命令行参数
     * <pre>
     *     如果可以继续向下运行，返回true;否则，返回false
     * </pre>
     *
     * @param args 命令行参数
     */
    private boolean arguments(String[] args) {
        boolean isConfig = false;

        if (args.length < 1) {
            usage();
            return false;
        }

        for (int i = 0; i < args.length; i++) {
            if (isConfig) {
                configFile = args[i];
                isConfig = false;
            } else if (args[i].equals("-config")) {
                isConfig = true;
            } else if (args[i].equals("-debug")) {
                debug = true;
            } else if (args[i].equals("-nonaming")) {
                useNaming = false;
            } else if (args[i].equals("-help")) {
                usage();
                return false;
            } else if (args[i].equals("start")) {
                starting = true;
            } else if (args[i].equals("stop")) {
                stopping = true;
            } else {
                usage();
                return false;
            }
        }
        return true;
    }

    /**
     * 启动或停止Tomcat应用
     */
    private void execute() {
        if (starting) {
            start();
        } else if (stopping) {
            stop();
        }
    }

    /**
     * 启动一个新的server实例
     */
    private void start() {
        Digester digester = createStartDigester();
        File file = configFile();
        try {
            InputSource is =
                    new InputSource("file://" + file.getAbsolutePath());
            FileInputStream fis = new FileInputStream(file);
            is.setByteStream(fis);
            digester.push(this);
            digester.parse(is);
            fis.close();
        } catch (Exception e) {
            System.out.println("Catalina.start: " + e);
            e.printStackTrace(System.out);
            System.exit(1);
        }

        // Setting additional variables
        if (!useNaming) {
            System.setProperty("catalina.useNaming", "false");
        } else {
            System.setProperty("catalina.useNaming", "true");
            String value = "org.apache.naming";
            String oldValue =
                    System.getProperty(javax.naming.Context.URL_PKG_PREFIXES);
            if (oldValue != null) {
                value = value + ":" + oldValue;
            }
            System.setProperty(javax.naming.Context.URL_PKG_PREFIXES, value);
            value = System.getProperty
                    (javax.naming.Context.INITIAL_CONTEXT_FACTORY);
            if (value == null) {
                System.setProperty
                        (javax.naming.Context.INITIAL_CONTEXT_FACTORY,
                                "org.apache.naming.java.javaURLContextFactory");
            }
        }

        // If a SecurityManager is being used, set properties for
        // checkPackageAccess() and checkPackageDefinition
        if (System.getSecurityManager() != null) {
            String access = Security.getProperty("package.access");
            if (access != null && access.length() > 0)
                access += ",";
            else
                access = "sun.,";
            Security.setProperty("package.access",
                    access + "org.apache.catalina.,org.apache.jasper.");
            String definition = Security.getProperty("package.definition");
            if (definition != null && definition.length() > 0)
                definition += ",";
            else
                definition = "sun.,";
            Security.setProperty("package.definition",
                    // FIX ME package "javax." was removed to prevent HotSpot
                    // fatal internal errors
                    definition + "java.,org.apache.catalina.,org.apache.jasper.");
        }

        // Replace System.out and System.err with a custom PrintStream
        SystemLogHandler log = new SystemLogHandler(System.out);
        System.setOut(log);
        System.setErr(log);

        Thread shutdownHook = new CatalinaShutdownHook();

        // Start the new server
        if (server instanceof Lifecycle) {
            try {
                server.initialize();
                ((Lifecycle) server).start();
                try {
                    // Register shutdown hook
                    Runtime.getRuntime().addShutdownHook(shutdownHook);
                } catch (Throwable t) {
                    // This will fail on JDK 1.2. Ignoring, as Tomcat can run
                    // fine without the shutdown hook.
                }
                // Wait for the server to be told to shut down
                server.await();
            } catch (LifecycleException e) {
                System.out.println("Catalina.start: " + e);
                e.printStackTrace(System.out);
                if (e.getThrowable() != null) {
                    System.out.println("----- Root Cause -----");
                    e.getThrowable().printStackTrace(System.out);
                }
            }
        }

        // Shut down the server
        if (server instanceof Lifecycle) {
            try {
                try {
                    // Remove the ShutdownHook first so that server.stop()
                    // doesn't get invoked twice
                    Runtime.getRuntime().removeShutdownHook(shutdownHook);
                } catch (Throwable t) {
                    // This will fail on JDK 1.2. Ignoring, as Tomcat can run
                    // fine without the shutdown hook.
                }
                ((Lifecycle) server).stop();
            } catch (LifecycleException e) {
                System.out.println("Catalina.stop: " + e);
                e.printStackTrace(System.out);
                if (e.getThrowable() != null) {
                    System.out.println("----- Root Cause -----");
                    e.getThrowable().printStackTrace(System.out);
                }
            }
        }

    }

    /**
     * 停止一个现有的server实例
     */
    private void stop() {

        // Create and execute our Digester
        Digester digester = createStopDigester();
        File file = configFile();
        try {
            InputSource is =
                    new InputSource("file://" + file.getAbsolutePath());
            FileInputStream fis = new FileInputStream(file);
            is.setByteStream(fis);
            digester.push(this);
            digester.parse(is);
            fis.close();
        } catch (Exception e) {
            System.out.println("Catalina.stop: " + e);
            e.printStackTrace(System.out);
            System.exit(1);
        }

        // Stop the existing server
        try {
            Socket socket = new Socket("127.0.0.1", server.getPort());
            OutputStream stream = socket.getOutputStream();
            String shutdown = server.getShutdown();
            for (int i = 0; i < shutdown.length(); i++)
                stream.write(shutdown.charAt(i));
            stream.flush();
            stream.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("Catalina.stop: " + e);
            e.printStackTrace(System.out);
            System.exit(1);
        }


    }

    /**
     * Return a File object representing our configuration file.
     */
    protected File configFile() {

        File file = new File(configFile);
        if (!file.isAbsolute())
            file = new File(System.getProperty("catalina.base"), configFile);
        return (file);

    }


    /**
     * 创建digester
     */
    private Digester createStartDigester() {
        Digester digester = new Digester();
        digester.setValidating(false);

        // Configure the actions we will be using
        digester.addObjectCreate("Server", "org.apache.catalina.core.StandardServer", "className");
        digester.addSetProperties("Server");
        digester.addSetNext("Server", "setServer", "org.apache.catalina.Server");

        digester.addObjectCreate("Server/GlobalNamingResources", "org.apache.catalina.deploy.NamingResources");
        digester.addSetProperties("Server/GlobalNamingResources");
        digester.addSetNext("Server/GlobalNamingResources", "setGlobalNamingResources", "org.apache.catalina.deploy.NamingResources");

        digester.addObjectCreate("Server/Listener", null, "className");
        digester.addSetProperties("Server/Listener");
        digester.addSetNext("Server/Listener", "addLifecycleListener", "org.apache.catalina.LifecycleListener");

        digester.addObjectCreate("Server/Service", "org.apache.catalina.core.StandardService", "className");
        digester.addSetProperties("Server/Service");
        digester.addSetNext("Server/Service", "addService", "org.apache.catalina.Service");

        digester.addObjectCreate("Server/Service/Listener", null, "className");
        digester.addSetProperties("Server/Service/Listener");
        digester.addSetNext("Server/Service/Listener", "addLifecycleListener", "org.apache.catalina.LifecycleListener");

        digester.addObjectCreate("Server/Service/Connector", "org.apache.catalina.connector.http.Connector", "className");
        digester.addSetProperties("Server/Service/Connector");
        digester.addSetNext("Server/Service/Connector", "addConnector", "org.apache.catalina.Connector");

        digester.addObjectCreate("Server/Service/Connector/Factory", "org.apache.catalina.net.DefaultServerSocketFactory", "className");
        digester.addSetProperties("Server/Service/Connector/Factory");
        digester.addSetNext("Server/Service/Connector/Factory", "setFactory", "org.apache.catalina.net.ServerSocketFactory");

        digester.addObjectCreate("Server/Service/Connector/Listener", null, "className");
        digester.addSetProperties("Server/Service/Connector/Listener");
        digester.addSetNext("Server/Service/Connector/Listener", "addLifecycleListener", "org.apache.catalina.LifecycleListener");

        // Add RuleSets for nested elements
        digester.addRuleSet(new NamingRuleSet("Server/GlobalNamingResources/"));
        digester.addRuleSet(new EngineRuleSet("Server/Service/"));
        digester.addRuleSet(new HostRuleSet("Server/Service/Engine/"));
        digester.addRuleSet(new ContextRuleSet("Server/Service/Engine/Default"));
        digester.addRuleSet(new NamingRuleSet("Server/Service/Engine/DefaultContext/"));
        digester.addRuleSet(new ContextRuleSet("Server/Service/Engine/Host/Default"));
        digester.addRuleSet(new NamingRuleSet("Server/Service/Engine/Host/DefaultContext/"));
        digester.addRuleSet(new ContextRuleSet("Server/Service/Engine/Host/"));
        digester.addRuleSet(new NamingRuleSet("Server/Service/Engine/Host/Context/"));

        digester.addRule("Server/Service/Engine", new SetParentClassLoaderRule(digester, parentClassLoader));
        return digester;
    }


    /**
     * Create and configure the Digester we will be using for shutdown.
     */
    protected Digester createStopDigester() {

        // Initialize the digester
        Digester digester = new Digester();
        if (debug)
            digester.setDebug(999);

        // Configure the rules we need for shutting down
        digester.addObjectCreate("Server",
                "org.apache.catalina.core.StandardServer",
                "className");
        digester.addSetProperties("Server");
        digester.addSetNext("Server",
                "setServer",
                "org.apache.catalina.Server");

        return (digester);

    }


    /**
     * 打印该Application的用法
     */
    private void usage() {
        System.out.println("usage: java org.apache.catalina.startup.Catalina"
                + " [-config {pathname}][-debug][-nonaming]{start|stop}");
    }


    // --------------------------------------- CatalinaShutdownHook Inner Class


    /**
     * Shutdown hook which will perform a clean shutdown of Catalina if needed.
     */
    protected class CatalinaShutdownHook extends Thread {

        public void run() {

            if (server != null) {
                try {
                    ((Lifecycle) server).stop();
                } catch (LifecycleException e) {
                    System.out.println("Catalina.stop: " + e);
                    e.printStackTrace(System.out);
                    if (e.getThrowable() != null) {
                        System.out.println("----- Root Cause -----");
                        e.getThrowable().printStackTrace(System.out);
                    }
                }
            }

        }
    }
}


// ------------------------------------------------------------ Private Classes


/**
 * Rule that sets the parent class loader for the top object on the stack, which must be a <code>Container</code>.
 */

final class SetParentClassLoaderRule extends Rule {

    public SetParentClassLoaderRule(Digester digester,
                                    ClassLoader parentClassLoader) {

        super(digester);
        this.parentClassLoader = parentClassLoader;

    }

    ClassLoader parentClassLoader = null;

    public void begin(Attributes attributes) throws Exception {

        if (digester.getDebug() >= 1)
            digester.log("Setting parent class loader");

        Container top = (Container) digester.peek();
        top.setParentClassLoader(parentClassLoader);

    }

}
