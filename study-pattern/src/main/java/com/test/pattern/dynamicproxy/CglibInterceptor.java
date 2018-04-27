package com.test.pattern.dynamicproxy;

import com.dranawhite.interceptor.BaseCglibInterceptor;

/**
 * @author dranawhite 2017/8/16
 * @version 1.0
 */
class CglibInterceptor extends BaseCglibInterceptor {

	@Override
	protected void setUp() {
		System.out.println("闪开，我要开始装逼了！");
	}

	@Override
	protected void tearDown() {
		System.out.println("装完逼就跑，真刺激！");
	}

}
