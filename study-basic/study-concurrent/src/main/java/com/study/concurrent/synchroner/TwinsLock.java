package com.study.concurrent.synchroner;

import com.dranawhite.common.common.ThreadUnit;
import com.dranawhite.exception.IllegalArgDranawhiteException;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 双子锁
 * <pre>
 *    	同一时间只允许两个线程同时访问
 * </pre>
 *
 * @author dranawhite
 * @version [1.0, 2018/5/16 15:01]
 */
public class TwinsLock implements Lock {

	private Sync sync = new Sync(2);

	private static final class Sync extends AbstractQueuedSynchronizer {

		Sync(int count) {
			if (count <= 0) {
				throw new IllegalArgDranawhiteException("count必须大于0");
			}
			setState(count);
		}

		@Override
		public int tryAcquireShared(int reduceCount) {
			for (; ; ) {
				int currentState = getState();
				int newCount = currentState - reduceCount;
				if (newCount < 0 || compareAndSetState(currentState, newCount)) {
					return newCount;
				}
			}
		}

		@Override
		public boolean tryReleaseShared(int returnCount) {
			for (; ; ) {
				int currentState = getState();
				int newCount = currentState + returnCount;
				if (compareAndSetState(currentState, newCount)) {
					return true;
				}
			}
		}
	}

	@Override
	public void lock() {
		sync.acquireShared(1);
	}

	@Override
	public void lockInterruptibly() throws InterruptedException {
		//TODO to be continue ....;

	}

	@Override
	public boolean tryLock() {
		//TODO to be continue ....;
		return false;
	}

	@Override
	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
		//TODO to be continue ....;
		return false;
	}

	@Override
	public void unlock() {
		sync.releaseShared(1);
	}

	@Override
	public Condition newCondition() {
		//TODO to be continue ....;
		return null;
	}

	public static void main(String[] args) throws IOException {
		final Lock lock = new TwinsLock();
		class Worker extends Thread {

			@Override
			public void run() {
				while (true) {
					lock.lock();
					System.out.println(Thread.currentThread().getName());
					ThreadUnit.sleep(3);
					System.out.println();
					lock.unlock();
				}
			}
		}

		for (int i = 0; i < 10; i++) {
			Worker worker = new Worker();
			worker.setName("Work" + i);
			worker.setDaemon(true);
			worker.start();
		}
		System.in.read();
	}
}