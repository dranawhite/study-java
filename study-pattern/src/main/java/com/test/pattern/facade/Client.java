package com.test.pattern.facade;

import lombok.Setter;

/**
 * @author liangyq
 * @version [1.0, 2018/4/28 12:19]
 */
public class Client {

	@Setter
	private Facade facade;

	public void run() {
		facade.operation();
	}

}
