package com.dranawhite.study.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dranawhite 2018/3/20
 */
public class ConcreteSubject implements Subject {

	private List<Observer> list = new ArrayList<>();

	@Override
	public void attach(Observer observer) {
		list.add(observer);
	}

	@Override
	public void detach(Observer observer) {
		list.add(observer);
	}

	@Override
	public void notify(String message) {
		for (Observer observer : list) {
			observer.update(message);
		}
	}
}
