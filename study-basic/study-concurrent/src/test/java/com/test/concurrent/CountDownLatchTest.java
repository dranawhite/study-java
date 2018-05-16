package com.test.concurrent;

import com.dranawhite.common.util.ThreadUnit;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * @author liangyq
 * @version [1.0, 2018/5/16 15:28]
 */
public class CountDownLatchTest {

	private Worker worker;

	@Test
	public void testCounDown() {
		CountDownLatch latch = new CountDownLatch(2);

		class Interrupt extends Thread {

			private Worker worker;

			public Interrupt(Worker worker) {
				this.worker = worker;
			}

			@Override
			public void run() {
				worker.interrupt();
			}
		}
		worker = new Worker(latch);
		worker.start();
		System.out.println("Time ----");
		Interrupt interrupt = new Interrupt(worker);
		interrupt.start();
		ThreadUnit.wait(latch);
		System.out.println("Time Over");
	}
}
