package com.dranawhite.study.pattern.template;

/**
 * @author dranawhite
 * @version [1.0, 2018/3/24 17:39]
 */
public class ConcreteService extends BaseService {

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
		System.out.println("Stopping--------!");
	}
}
