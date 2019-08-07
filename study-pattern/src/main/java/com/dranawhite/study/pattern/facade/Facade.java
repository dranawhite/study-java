package com.dranawhite.study.pattern.facade;

/**
 * @author dranawhite
 * @version [1.0, 2018/4/28 12:20]
 */
public class Facade {

	private SysOne sysOne = new SysOne();
	private SysTwo sysTwo = new SysTwo();

	/**
	 * 隐藏子系统的实现细节
	 */
	public void operation() {
		sysOne.operation();
		sysTwo.operation();
	}

}
