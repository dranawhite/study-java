package com.study.dubbo.provider.xml;

import com.dranawhite.common.exception.DranaRuntimeException;
import com.dranawhite.common.exception.ResultCodeEnum;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author dranawhite
 * @version [1.0, 2018/4/17 15:53]
 */
public class Provider {

	public static void main(String[] args) {
		try {
			ClassPathXmlApplicationContext context =
					new ClassPathXmlApplicationContext("applicationContext-dubbo-provider.xml");
			context.start();
			System.in.read();
		} catch (IOException ioe) {
			throw new DranaRuntimeException("突发异常", ResultCodeEnum.SERVICE_UNAVAILABLE, ioe);
		}
	}
}
