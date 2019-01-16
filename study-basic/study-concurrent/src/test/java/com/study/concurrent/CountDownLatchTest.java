package com.study.concurrent;

import com.dranawhite.common.common.ThreadUnit;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * @author dranawhite
 * @version [1.0, 2018/5/16 15:28]
 */
public class CountDownLatchTest {

	private Worker worker;

	@Test
	public void testCounDown() {
		CountDownLatch latch = new CountDownLatch(2);
		worker = new Worker(latch);
		worker.start();
		System.out.println("Time ----");
		ThreadUnit.wait(latch);
		System.out.println("Time Over");
	}
}
