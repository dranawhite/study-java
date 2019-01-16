package com.study.log.logback;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.LoggerFactory;

/**
 * @author dranawhite
 * @version [1.0, 2018/4/18 13:54]
 */
public class Main {

	public static void main(String[] args) {
		LogBackLogger logger = new LogBackLogger();
		logger.info();

		// 打印日志状态
		LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
		StatusPrinter.print(loggerContext);
	}
}
