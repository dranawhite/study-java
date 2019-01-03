package com.study.log;

/**
 * <pre>
 *     在core和log工程的com.study.log包下，都有LoggerBuilder工程；
 *     默认加载的是log工程下的LoggerBuilder；如果把log下的LoggerBuilder去掉后，则加载的是core工程下的
 * </pre>
 *
 * @author liangyq
 * @version [1.0, 2018/4/28 14:35]
 */
public class LogSpiPro {

	public static void main(String[] args) {
		LoggerBuilder builder = new LoggerBuilder();
		builder.print();
	}

}
