package com.test.concurrent.thread;

/**
 * @author liangyq
 * @version [1.0, 2018/5/15 17:43]
 */
public class ThreadPro extends Thread {

	@Override
	public void run() {
		long i = 0;
		while (true) {
			i++;
			if(Thread.currentThread().isInterrupted()) {
				System.out.println("Interrupted");
			}
		}
	}

	public static void main(String[] args) {
		// Thread interrupt
		ThreadPro td = new ThreadPro();
		td.start();
		td.interrupt();
	}

}
