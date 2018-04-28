package com.test.dubbo.consumer.xml;

import com.test.dubbo.provider.DubboRequest;
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
		DubboRequest request = new DubboRequest();
		request.setId(19);
		request.setName("jerry");
		String hello = dubboService.service(request).getData();
		System.out.println(hello);
	}
}
