package com.study.concurrent.unsafe;

import com.dranawhite.exception.DranawhiteException;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * 线程挂起与恢复
 *
 * @author dranawhite
 * @version [1.0, 2018/5/16 11:33]
 */
public class UnsafePark extends Thread {

	@Override
	public void run() {
		System.out.println("This is a Thread!");
		LockSupport.park();
		System.out.println("I am back!");
	}

	public static void main(String[] args) {
		try {
			UnsafePark park = new UnsafePark();
			park.start();
			TimeUnit.SECONDS.sleep(5);
			LockSupport.unpark(park);
		} catch (InterruptedException ex) {
			throw new DranawhiteException();
		}
	}
}
