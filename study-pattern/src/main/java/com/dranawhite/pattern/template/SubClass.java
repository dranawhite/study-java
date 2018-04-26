package com.dranawhite.pattern.template;

/**
 * @author liangyq
 * @version [1.0, 2018/3/24 17:39]
 */
public class SubClass extends SuperClass {

	@Override
	void start() {
		System.out.println("Starting--------!");
	}

	@Override
	void run() {
		System.out.println("Running--------!");
	}

	@Override
	void stop() {
		System.out.println("Stoping--------!");
	}
}
