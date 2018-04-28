package com.test.log.jdk;

/**
 * JDK自带日志管理
 * <pre>
 *      LogManager与Logger是一对多关系，整个JVM运行时只有一个LogManager，且所有的Logger均在LogManager中;
 *      Logger与handler是多对多关系，Logger在进行日志输出时会调用所有的handler进行日志处理; handler相当于Appender;
 *      handler与formatter是一对一关系，一个handler有一个formatter进行日志的格式化处理; formatter相当于Logout;
 *      Logger与level是一对一关系，handler与level是一对一关系;
 * </pre>
 *
 * @author dranawhite 2017/8/21
 * @version 1.0
 */
public class Main {

	public static void main(String[] args) {
		JdkLogger logger = new JdkLogger();
		logger.info("JDK自带日志");
	}

}
