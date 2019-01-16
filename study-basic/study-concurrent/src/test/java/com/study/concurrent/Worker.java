package com.study.concurrent;

import com.dranawhite.common.common.ThreadUnit;

import java.util.concurrent.CountDownLatch;

class Worker extends Thread {

	private CountDownLatch latch;

	public Worker(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		ThreadUnit.sleep(5);
		System.out.println("Time 1");
		latch.countDown();
		ThreadUnit.sleep(5);
		System.out.println("Time 2");
		latch.countDown();
	}
}