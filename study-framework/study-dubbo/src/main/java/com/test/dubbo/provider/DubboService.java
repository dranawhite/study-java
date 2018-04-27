package com.test.dubbo.provider;

/**
 * @author liangyq
 * @version [1.0, 2018/4/17 15:49]
 */
public class DubboService implements IDubboService {

	@Override
	public String sayHello() {
		return "Hello World!";
	}
}
