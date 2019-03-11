package com.study.tomcat.server;

import com.study.tomcat.connector.Connector;
import com.study.tomcat.container.Container;
import com.study.tomcat.lifecycle.LifecycleException;

/**
 * Service是一组connector和一个container的集合
 *
 * @author dranawhite
 * @version $Id: Service.java, v 0.1 2019-03-09 13:51 dranawhite Exp $$
 */
public interface Service {

    /**
     * 返回service相关的container
     */
    Container getContainer();

    /**
     * 设置service的container
     *
     * @param container 新的container
     */
    void setContainer(Container container);

    /**
     * 返回service信息和版本号
     *
     * <code>&lt;description&gt;/&lt;version&gt;</code>.
     */
    String getInfo();

    /**
     * 返回service名称
     */
    String getName();

    /**
     * 设置service名称
     *
     * @param name 新的service名称
     */
    void setName(String name);

    /**
     * 返回service关联的server
     */
    Server getServer();

    /**
     * 设置service关联的server
     *
     * @param server 关联的server
     */
    void setServer(Server server);

    /**
     * 添加connector
     *
     * @param connector 待添加的connector
     */
    void addConnector(Connector connector);


    /**
     * 返回service关联的connector
     */
    Connector[] findConnectors();


    /**
     * 从service中移除connector
     *
     * @param connector 待移除的connector
     */
    void removeConnector(Connector connector);

    /**
     * 调用<code>initialization</code>，该方法用来在Unix环境下绑定connector和特定端口
     *
     * @throws LifecycleException 如果server已实例化，抛出异常.
     */
    void initialize() throws LifecycleException;
}
