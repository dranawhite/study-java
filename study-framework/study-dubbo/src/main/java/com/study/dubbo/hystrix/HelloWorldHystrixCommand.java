package com.study.dubbo.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * @author liangyq
 * @version [1.0, 2018/6/15 16:47]
 */
public class HelloWorldHystrixCommand extends HystrixCommand<String> {

	private String name;

	protected HelloWorldHystrixCommand(String name) {
		super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
		this.name = name;
	}

	@Override
	protected String run() {
		return "Hello " + name;
	}
}
