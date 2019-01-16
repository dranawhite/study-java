package com.study.concurrent.thread;

import com.dranawhite.exception.DranawhiteException;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * <pre>
 *     interrupt方法可以唤醒处于wait(), join(), park()状态的线程
 * </pre>
 *
 * @author dranawhite
 * @version [1.0, 2018/5/15 17:43]
 */
public class ThreadPro extends Thread {

	@Override
	public void run() {
		long i = 0;
		while (true) {
			i++;
			System.out.println("Oh, No!");
			LockSupport.park();
			System.out.println("I am back!");
			if (Thread.currentThread().isInterrupted()) {
				System.out.println("Interrupted");
				return;
			}
		}
	}

	public static void main(String[] args) {
		try {
			// Thread interrupt
			ThreadPro td = new ThreadPro();
			td.start();
			TimeUnit.SECONDS.sleep(5);
			System.out.println("Hey, man waking up!");
			LockSupport.unpark(td);
			TimeUnit.SECONDS.sleep(5);
			System.out.println("Hey, guy interrupting!");
			td.interrupt();
		} catch (InterruptedException ex) {
			throw new DranawhiteException(ex);
		}
	}

}
