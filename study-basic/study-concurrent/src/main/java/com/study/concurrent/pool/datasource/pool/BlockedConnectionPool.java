package com.study.concurrent.pool.datasource.pool;

import com.dranawhite.common.exception.DranaSystemException;
import com.dranawhite.common.exception.GenericResultCode;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author dranawhite
 * @version $Id: BlockedConnectionPool.java, v 0.1 2019-02-19 16:06 dranawhite Exp $$
 */
public class BlockedConnectionPool extends ConnectionPool {

    /**
     * 处于等待状态的连接数
     */
    private static AtomicInteger waitConnectionNum = new AtomicInteger(0);

    private static final int DEFAULT_CORE_SIZE = 10;

    private static final int DEFAULT_MAX_SIZE = 50;

    private static final int DEFAULT_MAX_WAIT_SIZE = 100;

    private static final int DEFAULT_MAX_WAIT_SECONDS = 60;

    private static final int DEFAULT_MAX_ACTIVE_SECONDS = 60;

    private SyncLock syncLock;

    private int maxWaitSize;

    private int maxWaitSeconds;

    public BlockedConnectionPool(int coreSize, int maxSize, int maxWaitSize, int maxWaitSeconds, int maxActiveSeconds) {
        super(coreSize, maxSize, maxActiveSeconds);

        syncLock = new SyncLock(maxSize);
        this.maxWaitSize = maxWaitSize;
        this.maxWaitSeconds = maxWaitSeconds;
    }

    public BlockedConnectionPool() {
        super(DEFAULT_CORE_SIZE, DEFAULT_MAX_SIZE, DEFAULT_MAX_ACTIVE_SECONDS);

        syncLock = new SyncLock(DEFAULT_MAX_SIZE);
        this.maxWaitSize = DEFAULT_MAX_WAIT_SIZE;
        this.maxWaitSeconds = DEFAULT_MAX_WAIT_SECONDS;
    }

    public ConnectionHolder borrow(String connType) {
        if (syncLock.tryLock()) {
            return getConnection(connType);
        }
        throw new DranaSystemException("获取数据源连接超时!", GenericResultCode.SYSTEM_ERROR);
    }

    @Override
    public void release(ConnectionHolder connectionHolder) {
        syncLock.unlock();
        super.release(connectionHolder);
    }

    private final class Sync extends AbstractQueuedSynchronizer {

        private static final long serialVersionUID = -9113063375029997659L;

        Sync(int state) {
            compareAndSetState(0, state);
        }

        @Override
        protected int tryAcquireShared(int acquires) {
            final int state = getState();
            if (state < 1) {
                return -1;
            }
            if (compareAndSetState(state, state - 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return 1;
            } else {
                return -1;
            }
        }

        @Override
        protected boolean tryReleaseShared(int releases) {
            final int state = getState();
            return compareAndSetState(state, state + 1);
        }
    }

    private final class SyncLock implements Lock {

        private Sync sync;

        SyncLock(int max) {
            sync = new Sync(max);
        }

        @Override
        public boolean tryLock() {
            if (waitConnectionNum.get() > maxWaitSize) {
                throw new DranaSystemException("获取数据源超时!", GenericResultCode.SYSTEM_ERROR);
            }
            waitConnectionNum.incrementAndGet();
            try {
                return sync.tryAcquireSharedNanos(1, TimeUnit.SECONDS.toNanos(maxWaitSeconds));
            } catch (Exception ex) {
                waitConnectionNum.decrementAndGet();
                throw new DranaSystemException("获取数据源失败!", GenericResultCode.SYSTEM_ERROR, ex);
            }
        }

        @Override
        public void unlock() {
            waitConnectionNum.decrementAndGet();
            sync.tryReleaseShared(1);
        }

        @Override
        public boolean tryLock(long time, TimeUnit unit) {
            return false;
        }

        @Override
        public void lock() {

        }

        @Override
        public void lockInterruptibly() {

        }

        @Override
        public Condition newCondition() {
            return null;
        }
    }

}
