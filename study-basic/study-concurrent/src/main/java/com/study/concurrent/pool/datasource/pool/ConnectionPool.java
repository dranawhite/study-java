package com.study.concurrent.pool.datasource.pool;

import org.apache.commons.lang3.StringUtils;

import java.sql.Connection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author dranawhite
 * @version $Id: ConnectionPool.java, v 0.1 2019-02-19 15:54 dranawhite Exp $$
 */
public class ConnectionPool {

    private ConcurrentLinkedQueue<ConnectionHolder> spareConnectionHolders;

    private ConcurrentLinkedQueue<ConnectionHolder> usedConnectionHolders;

    private AtomicInteger counter = new AtomicInteger();

    private int maxActiveSeconds;

    private int coreSize;

    private int maxSize;

    ConnectionPool(int coreSize, int maxSize, int maxActiveSeconds) {
        spareConnectionHolders = new ConcurrentLinkedQueue<>();
        usedConnectionHolders = new ConcurrentLinkedQueue<>();

        this.coreSize = coreSize;
        this.maxSize = maxSize;
        this.maxActiveSeconds = maxActiveSeconds;
    }

    ConnectionHolder getConnection(String connType) {
        Iterator<ConnectionHolder> iterator = spareConnectionHolders.iterator();
        while (iterator.hasNext()) {
            ConnectionHolder spareConnectionHolder = iterator.next();
            if (StringUtils.equals(spareConnectionHolder.getType(), connType) && spareConnectionHolder.markUsing()) {
                iterator.remove();
                usedConnectionHolders.add(spareConnectionHolder);
                return spareConnectionHolder;
            }
        }
        ConnectionHolder connectionHolder = newConnectionHolder(connType);
        if (connectionHolder != null) {
            return connectionHolder;
        }
        // 若没有空余空间创建连接，则释放多于连接后重新创建
        destroyExcessConnection();
        return newConnectionHolder(connType);
    }

    protected void release(ConnectionHolder connectionHolder) {
        usedConnectionHolders.removeIf(usedConnectionHolder -> usedConnectionHolder.getId() == connectionHolder.getId());
        connectionHolder.setLastActiveTimeStamp(System.currentTimeMillis());
        connectionHolder.markIdle();
        spareConnectionHolders.add(connectionHolder);
    }

    void startPoolDestroyer() {
        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1, (Runnable r) -> {
            String name = "Connection-Pool-Destroyer";
            return new Thread(r, name);
        });
        executorService.scheduleAtFixedRate(new PoolDestroyer(), maxActiveSeconds, maxActiveSeconds, TimeUnit.SECONDS);
    }

    private ConnectionHolder newConnectionHolder(String connType) {
        if (counter.get() < maxSize) {
            ConnectionHolder connectionHolder = new ConnectionHolder();
            connectionHolder.setType(connType);
            connectionHolder.setId(counter.incrementAndGet());
            connectionHolder.setConnection(newConnection(connType));
            usedConnectionHolders.add(connectionHolder);
            return connectionHolder;
        }
        return null;
    }

    private Connection newConnection(String connType) {
        // TODO
        return null;
    }

    private void destroyExcessConnection() {
        int counterNum = counter.get();
        System.out.println("空间不足释放——当前: " + counterNum + "; Spare: " + spareConnectionHolders.size() + "; Used: " + usedConnectionHolders.size());
        if (counterNum <= coreSize) {
            return;
        }
        int releaseNum = counterNum - coreSize;
        int index = releaseNum;
        Iterator<ConnectionHolder> iterator = spareConnectionHolders.iterator();
        while (iterator.hasNext()) {
            ConnectionHolder connectionHolder = iterator.next();
            if (index > 0 && connectionHolder.markAbandoned()) {
                iterator.remove();
                index--;
            }
        }
        counter.getAndAdd(index - releaseNum);
        System.out.println("空间不足释放完成——当前: " + counter.get() + "; Spare: " + spareConnectionHolders.size() +
                "; Used: " + usedConnectionHolders.size() + "; 释放: " + (releaseNum - index));
    }

    class PoolDestroyer implements Runnable {

        @Override
        public void run() {
            int counterNum = counter.get();
            System.out.println("超时释放——当前: " + counterNum + "; Spare: " + spareConnectionHolders.size() + "; Used: " + usedConnectionHolders.size());
            if (counterNum <= coreSize) {
                return;
            }
            int releaseNum = counterNum - coreSize;
            int index = releaseNum;
            long curTimestamp = System.currentTimeMillis();
            Iterator<ConnectionHolder> iterator = spareConnectionHolders.iterator();
            while (iterator.hasNext()) {
                ConnectionHolder connectionHolder = iterator.next();
                if (curTimestamp - maxActiveSeconds < connectionHolder.getLastActiveTimeStamp()) {
                    break;
                }
                if (index > 0 && connectionHolder.markAbandoned()) {
                    iterator.remove();
                    index--;
                } else {
                    break;
                }
            }
            counter.getAndAdd(index - releaseNum);
            System.out.println("超时释放完成——当前: " + counter.get() + "; Spare: " + spareConnectionHolders.size() +
                    "; Used: " + usedConnectionHolders.size() + "; 释放: " + (releaseNum - index));
        }
    }
}
