package com.study.pattern.observer;

/**
 * 实际的观察者
 *
 * @author dranawhite 2018/3/20
 */
public class ConcreteObserver implements Observer {

	@Override
	public void update(String message) {
		String msg = "收到通知——'" + message +"'： 汪";
		System.out.println(msg);
	}
}
