package com.study.tomcat.connector;

import com.study.tomcat.container.Container;
import com.study.tomcat.lifecycle.LifecycleException;
import com.study.tomcat.server.Service;

/**
 * @author dranawhite
 * @version $Id: Connector.java, v 0.1 2019-03-09 13:51 dranawhite Exp $$
 */
public interface Connector {

    /**
     * 返回连接器关联的Container
     */
    Container getContainer();

    /**
     * 配置连接器关联的容器
     *
     * @param container 新使用的容器
     */
    void setContainer(Container container);

    /**
     * 返回container使用的ServerSocket工厂
     */
    ServerSocketFactory getFactory();

    /**
     * 配置container使用的ServerSocket工厂
     *
     * @param factory The new server socket factory
     */
    void setFactory(ServerSocketFactory factory);

    /**
     * 返回连接器信息
     */
    String getInfo();

    /**
     * 如果是非SSL请求，直接返回该端口号; 如果是SSL请求，则重定向到该端口号
     */
    int getRedirectPort();

    /**
     * 配置直连端口号
     *
     * @param redirectPort 重定向端口号
     */
    void setRedirectPort(int redirectPort);

    /**
     * 返回连接器请求的scheme，默认是http
     */
    String getScheme();

    /**
     * 配置连接器请求的scheme
     *
     * @param scheme 新的scheme
     */
    void setScheme(String scheme);

    /**
     * 返回请求的安全连接标志，默认是false
     */
    boolean getSecure();

    /**
     * 设置安全连接标志
     *
     * @param secure 新的安全连接标志
     */
    void setSecure(boolean secure);

    /**
     * 返回关联的Service
     */
    Service getService();

    /**
     * 设置关联的service
     *
     * @param service 持有Engine的service
     */
    void setService(Service service);

    Request createRequest();

    Response createResponse();

    /**
     * @throws LifecycleException 若Server已初始化抛出异常
     */
    void initialize() throws LifecycleException;

}
