package com.study.dubbo.hystrix;

/**
 * @author liangyq
 * @version [1.0, 2018/6/15 16:51]
 */
public class Main {

	public static void main(String[] args) {
		String result = new HelloWorldHystrixCommand("World").execute();
		System.out.println(result);
	}

}
