package com.dranawhite.pattern.template;

/**
 * 模板类
 *
 * @author liangyq
 * @version [1.0, 2018/3/24 17:37]
 */
public abstract class SuperClass {

	abstract void start();

	abstract void run();

	abstract void stop();

	/**
	 * 模板方法
	 */
	public void template() {
		start();
		run();
		stop();
	}
}
