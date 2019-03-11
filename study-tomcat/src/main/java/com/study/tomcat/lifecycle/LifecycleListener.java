package com.study.tomcat.lifecycle;

/**
 *
 * @author dranawhite
 * @version $Id: LifecycleListener.java, v 0.1 2019-03-09 14:18 dranawhite Exp $$
 */
public interface LifecycleListener {

    /**
     * 通知特定事件
     *
     * @param event 发生的事件
     */
    void lifecycleEvent(LifecycleEvent event);
}
