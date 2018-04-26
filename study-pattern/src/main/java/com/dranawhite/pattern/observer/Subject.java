package com.dranawhite.pattern.observer;

/**
 * @author liangyq 2018/3/20
 */
public interface Subject {

	/**
	 * 增加订阅者
	 *
	 * @param observer
	 */
	void attach(Observer observer);

	/**
	 * 删除订阅者
	 *
	 * @param observer
	 */
	void detach(Observer observer);

	/**
	 * 通知订阅者更新消息
	 */
	void notify(String message);
}
