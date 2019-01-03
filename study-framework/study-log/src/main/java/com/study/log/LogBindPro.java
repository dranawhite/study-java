package com.study.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <pre>
 * Slf4j绑定过程：
 * 		1) 在classpath中查找org.slf4j.impl.StaticLoggerBinder类
 * 	    2) Slf4j默认使用Log4j
 * 	    3) Logger使用Adapter适配器模式
 * </pre>
 *
 * @author liangyq
 * @version [1.0, 2018/4/28 11:29]
 */
public class LogBindPro {

	private Logger log = LoggerFactory.getLogger(LogBindPro.class);

	public void info(String msg) {
		log.info(msg);
	}

	public static void main(String[] args) {
		LogBindPro pro = new LogBindPro();
		pro.info("Hello Slf!");
	}

}
