package com.study.concurrent.pool.datasource.pool;

import java.sql.Connection;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import lombok.Getter;
import lombok.Setter;

/**
 * 连接器
 *
 * @author dranawhite
 * @version $Id: ConnectionHolder.java, v 0.1 2019-02-19 15:52 dranawhite Exp $$
 */
@Setter
@Getter
public class ConnectionHolder {

    private static final int USING = 1;

    private static final int IDLE = 2;

    private static final int ABANDONED = 3;

    private AtomicInteger state = new AtomicInteger(USING);

    private int id;

    private long lastActiveTimeStamp;

    private Connection connection;

    private String type;

    AtomicBoolean using = new AtomicBoolean(true);

    boolean markUsing() {
        return state.compareAndSet(IDLE, USING);
    }

    boolean markIdle() {
        return state.compareAndSet(USING, IDLE);
    }

    boolean markAbandoned() {
        return state.compareAndSet(IDLE, ABANDONED);
    }
}
