package com.dranawhite.study.pattern.proxy.dynamic;

import com.dranawhite.interceptor.BaseCglibInterceptor;

/**
 * <pre>
 * 		Cglib动态代理实现如下:
 * 		1)实现MethodInterceptor接口
 * 		2)生成一个代理类继承被代理的类
 * 		3)在执行代理类的方法时依赖MethodInterceptor的intercept方法
 * </pre>
 *
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
