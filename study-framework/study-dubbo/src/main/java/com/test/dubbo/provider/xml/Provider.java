package com.test.dubbo.provider.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liangyq
 * @version [1.0, 2018/4/17 15:53]
 */
public class Provider {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext-dubbo-provider.xml");
		context.start();
		System.in.read();
	}
}
