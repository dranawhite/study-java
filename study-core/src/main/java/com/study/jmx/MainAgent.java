package com.study.jmx;

import com.sun.jdmk.comm.HtmlAdaptorServer;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;

/**
 *
 * <pre>
 *     MXBean提供工具对Bean进行管理
 * </pre>
 * <pre>
 *      MXBean使用规范:
 *      1)每一个MBean定义一个接口，这个接口的名字必须是其被管理的资源的对象类名称后面加上MBean
 *      2)定义一个类实现MBean接口，并且把它们注册到MBeanServer中
 *      3)编译运行，在浏览器中输入localhost:8082，可以对程序进行管理
 * </pre>
 *
 * @author dranawhite
 * @version $Id: MainAgent.java, v 0.1 2019-01-03 14:26 dranawhite Exp $$
 */
public class MainAgent {

    public static void main(String[] args) {
        try {
            MBeanServer server = ManagementFactory.getPlatformMBeanServer();
            // 命名格式：域名:name=MBean名称
            ObjectName person = new ObjectName("jmxBean:name=person");
            server.registerMBean(new Person(), person);

            ObjectName adapter = new ObjectName("MainAgent:name=htmladapter,port=8082");
            HtmlAdaptorServer adapterServer = new HtmlAdaptorServer();
            server.registerMBean(adapterServer, adapter);
            adapterServer.start();
            System.in.read();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
