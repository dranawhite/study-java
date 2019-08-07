package com.dranawhite.study.pattern.facade;

import lombok.Setter;

/**
 * @author dranawhite
 * @version [1.0, 2018/4/28 12:19]
 */
public class Client {

	@Setter
	private Facade facade;

	public void run() {
		facade.operation();
	}

}
