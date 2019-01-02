package com.study.pattern.facade;

/**
 * 门面模式隐藏具体的内部实现细节
 *
 * @author liangyq
 * @version [1.0, 2018/4/28 12:19]
 */
public class Main {

	public static void main(String[] args) {
		Client client = new Client();
		client.setFacade(new Facade());
		client.run();
	}

}
