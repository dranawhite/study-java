package com.study.tomcat.server;

import com.study.tomcat.lifecycle.LifecycleException;

/**
 * @author dranawhite
 * @version $Id: Server.java, v 0.1 2019-03-09 13:51 dranawhite Exp $$
 */
public interface Server {

    /**
     * 返回Server信息和版本号
     *
     * <code>&lt;description&gt;/&lt;version&gt;</code>.
     */
    String getInfo();


    /**
     * 返回全局命名资源
     */
    NamingResources getGlobalNamingResources();


    /**
     * Set全局命名资源
     *
     * @param globalNamingResources 新的JNDI资源
     */
    void setGlobalNamingResources(NamingResources globalNamingResources);


    /**
     * shutdown命令的端口
     */
    int getPort();


    /**
     * 设置shutdown命令的端口
     *
     * @param port 新的端口
     */
    void setPort(int port);


    /**
     * 返回shutdown命令字符串
     */
    String getShutdown();


    /**
     * 设置shutdown命令端口
     *
     * @param shutdown 新的shutdown命令
     */
    void setShutdown(String shutdown);

    /**
     * 添加Service
     *
     * @param service 待添加的service
     */
    void addService(Service service);


    /**
     * 等待shutdown命令
     */
    void await();


    /**
     * 查找符合的service，没有返回
     * <code>null</code>.
     *
     * @param name 待返回的service名称
     */
    Service findService(String name);

    /**
     * 返回server中定义的service
     */
    Service[] findServices();


    /**
     * 从server中移除service
     *
     * @param service The Service to be removed
     */
    void removeService(Service service);

    /**
     * 调用<code>initialization</code>，该方法用来在Unix环境下绑定connector和特定端口
     *
     * @throws LifecycleException 如果server已实例化，抛出异常.
     */
    void initialize() throws LifecycleException;

}
