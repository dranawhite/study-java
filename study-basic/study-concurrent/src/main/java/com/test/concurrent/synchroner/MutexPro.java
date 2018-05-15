package com.test.concurrent.synchroner;

import com.dranawhite.exception.IllegalMonitorStateDranawhiteException;
import com.dranawhite.exception.InterruptedDranawhiteException;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 互斥量
 * <pre>
 *     同步器使用示例
 * </pre>
 *
 * @author liangyq
 * @version [1.0, 2018/5/15 15:19]
 */
public class MutexPro implements Lock {

	/**
	 * 同步器
	 */
	private static class Sync extends AbstractQueuedSynchronizer {

		/**
		 * 当前同步器是否在独占模式下被线程占用，一般该方法表示是否被当前线程所独占
		 *
		 * @return 是否被独占
		 */
		@Override
		protected boolean isHeldExclusively() {
			return getState() == 1;
		}

		/**
		 * 共享式获取同步状态，返回大于等于0的值，表示获取成功，反之获取失败
		 *
		 * @param acquires
		 * @return
		 */
		@Override
		protected int tryAcquireShared(int acquires) {
			// Do Nothing
			return -1;
		}

		/**
		 * 共享式释放同步状态
		 *
		 * @param releases
		 * @return
		 */
		@Override
		public boolean tryReleaseShared(int releases) {
			// Do Nothing
			return false;
		}

		/**
		 * 独占式获取同步状态，实现该方法需要查询当前状态并判断同步状态是否符合预期，然后再进行CAS设置同步状态
		 *
		 * @param acquires
		 * @return 是否成功
		 */
		@Override
		public boolean tryAcquire(int acquires) {
			if (compareAndSetState(0, 1)) {
				setExclusiveOwnerThread(Thread.currentThread());
				return true;
			}
			return false;
		}

		/**
		 * 独占式释放同步状态，等待获取同步状态的线程将会有机会获取同步状态
		 *
		 * @param releases
		 * @return 是否释放成功
		 */
		@Override
		protected boolean tryRelease(int releases) {
			if (getState() == 0) {
				throw new IllegalMonitorStateDranawhiteException("同步器状态异常");
			}
			setState(0);
			return true;
		}

		Condition newCondition() {
			return new ConditionObject();
		}
	}

	private final Sync sync = new Sync();

	public boolean isLocked() {
		return sync.isHeldExclusively();
	}

	public boolean hasQueuedThreads() {
		return sync.hasQueuedThreads();
	}

	@Override
	public void lock() {
		sync.acquire(1);
	}

	@Override
	public void lockInterruptibly() {
		try {
			sync.acquireInterruptibly(1);
		} catch (InterruptedException ex) {
			throw new InterruptedDranawhiteException("同步器获取锁时中断", ex);
		}
	}

	@Override
	public boolean tryLock() {
		return sync.tryAcquire(1);
	}

	@Override
	public boolean tryLock(long time, TimeUnit unit) {
		try {
			return sync.tryAcquireNanos(1, unit.toNanos(time));
		} catch (InterruptedException ex) {
			throw new InterruptedDranawhiteException("同步器获取锁中断", ex);
		}
	}

	@Override
	public void unlock() {
		sync.release(1);
	}

	@Override
	public Condition newCondition() {
		return sync.newCondition();
	}

	public static void main(String[] args) {
		MutexPro pro = new MutexPro();
		pro.lock();
		pro.lock();
	}
}
