package com.test.dubbo.consumer.xml;

import com.test.dubbo.provider.IDubboService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liangyq
 * @version [1.0, 2018/4/17 15:57]
 */
public class Consumer {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext-dubbo-consumer.xml");
		context.start();
		IDubboService dubboService = context.getBean("dubboService", IDubboService.class);
		String hello = dubboService.sayHello();
		System.out.println(hello);
	}
}
