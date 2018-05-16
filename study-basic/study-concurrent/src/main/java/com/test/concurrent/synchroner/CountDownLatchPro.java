package com.test.concurrent.synchroner;

import com.dranawhite.exception.DranawhiteException;

import java.util.concurrent.CountDownLatch;

/**
 * @author liangyq
 * @version [1.0, 2018/5/15 15:08]
 */
public class CountDownLatchPro {

	private CountDownLatch latch = new CountDownLatch(2);

	public void countDown() {
		latch.countDown();
	}

	public void await() {
		try {
			latch.await();
		} catch (InterruptedException ex) {
			throw new DranawhiteException(ex);
		}
	}
}
