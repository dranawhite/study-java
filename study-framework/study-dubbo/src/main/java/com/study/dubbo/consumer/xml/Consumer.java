package com.study.dubbo.consumer.xml;

import com.dranawhite.exception.DranawhiteException;
import com.study.dubbo.provider.DubboRequest;
import com.study.dubbo.provider.IDubboService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author dranawhite
 * @version [1.0, 2018/4/17 15:57]
 */
public class Consumer {

	public static void main(String[] args) {
		try {
			ClassPathXmlApplicationContext context =
					new ClassPathXmlApplicationContext("applicationContext-dubbo-consumer.xml");
			context.start();
			IDubboService dubboService = context.getBean("dubboService", IDubboService.class);
			DubboRequest request = new DubboRequest();
			request.setId(19);
			request.setName("jerry");
			String hello = dubboService.service(request).getData();
			System.out.println(hello);
			System.in.read();
		} catch (IOException ex) {
			throw new DranawhiteException(ex);
		}
	}
}
