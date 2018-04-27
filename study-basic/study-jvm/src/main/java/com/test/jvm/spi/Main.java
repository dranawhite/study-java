package com.test.jvm.spi;

import com.test.core.spi.SayHello;

import java.sql.Driver;
import java.util.ServiceLoader;

/**
 * <pre>
 * 在META-INF文件夹下，建立services文件夹，在services文件夹里面建立一个文件，文件名跟我们需要实现的服务的全限定名一样
 * </pre>
 * 注：ServiceLoader从JDK1.6才有的
 *
 * @author dranawhite 2017/10/31
 * @version 1.0
 */
public class Main {

	public static void main(String[] args) {
		System.out.println("====加载Study-Core定义的SayHello====");
		loadSayHello();
		System.out.println("====加载数据库Driver====");
		loadDriver();
	}

	private static void loadSayHello() {
		ServiceLoader<SayHello> loader = ServiceLoader.load(SayHello.class);
		for (SayHello sayHello : loader) {
			sayHello.sayHello();
		}
	}

	private static void loadDriver() {
		ServiceLoader<Driver> loader = ServiceLoader.load(Driver.class);
		for (Driver driver : loader) {
			System.out.println(driver.toString());
		}
	}

}
