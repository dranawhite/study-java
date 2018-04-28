package com.test.log.log4j1;

/**
 * @author liangyq
 * @version [1.0, 2018/4/28 13:57]
 */
public class Main {

	private static Log4j1Logger logger = new Log4j1Logger();

	public static void main(String[] args) {
		logger.info();
		logger.debug();
		logger.warn();
	}
}
