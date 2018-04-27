package com.test.pattern.observer;

/**
 * 观察者模式
 * <pre>
 *     又叫发布/订阅模式，让多个观察者对象同时监控谋一个主题对象；
 *     这个主题对象在发生变化时会通知所有的观察者对象
 *
 *     类图：/docs/observer.png
 * </pre>
 *
 * @author liangyq 2018/3/20
 */
public class Main {

	public static void main(String[] args) {
		Subject subject = new ConcreteSubject();
		subject.attach(new ConcreteObserver());
		subject.notify("开饭啦！");
	}

}
