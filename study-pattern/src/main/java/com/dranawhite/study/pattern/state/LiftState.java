package com.dranawhite.study.pattern.state;

/**
 * 状态角色
 *
 * @author dranawhite
 * @version : State.java, v 0.1 2019-08-14 13:46 dranawhite Exp $$
 */
public interface LiftState {

    /**
     * open
     */
    default void open() {}

    /**
     * close
     */
    default void close() {}

    /**
     * run
     */
    default void run() {}

    /**
     * stop
     */
    default void stop() {}
}
