/**
 * ymm56.com Inc. Copyright (c) 2013-2019 All Rights Reserved.
 */
package com.study.concurrent.synchroner;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 *
 * @author liangyuquan
 * @version $Id: SharedLock.java, v 0.1 2019-01-03 20:01 liangyuquan Exp $$
 */
public class SharedLock {

    private static final int MAX_CONNECTION_NUM = 50;

    private static final int MAX_WAIT_NUM = 100;

    private static final int MAX_WAIT_SECONDS = 60;

    private static AtomicInteger waitNum = new AtomicInteger(0);

    private SyncLock syncLock;

    public SharedLock() {
        syncLock = new SyncLock(MAX_CONNECTION_NUM);
    }

    public void release() {
        syncLock.unlock();
    }

    private final class Sync extends AbstractQueuedSynchronizer {

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
            if (compareAndSetState(state, state + 1)) {
                return true;
            } else {
                return false;
            }
        }
    }

    private final class SyncLock implements Lock {

        private Sync sync;

        SyncLock(int max) {
            sync = new Sync(max);
        }

        @Override
        public boolean tryLock() {
            try {
                if (waitNum.get() > MAX_WAIT_NUM) {
                    throw new RuntimeException("获取锁超时!");
                }
                waitNum.incrementAndGet();
                return sync.tryAcquireSharedNanos(1, TimeUnit.SECONDS.toNanos(MAX_WAIT_SECONDS));
            } catch (Exception ex) {
                waitNum.decrementAndGet();
                throw new RuntimeException("获取锁失败!", ex);
            }
        }

        @Override
        public void unlock() {
            waitNum.decrementAndGet();
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
