package com.study.dubbo.consumer.api;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.dranawhite.common.util.PropertyLoader;
import com.study.dubbo.provider.DubboRequest;
import com.study.dubbo.provider.IDubboService;

/**
 * @author dranawhite
 * @version [1.0, 2018/4/17 17:23]
 */
public class Consumer {

	public static void main(String[] args) {
		PropertyLoader.load("dubbo.properties");
		// 当前应用配置
		ApplicationConfig application = new ApplicationConfig();
		application.setName("Test-dubbo-consumer");

		// 连接注册中心配置
		RegistryConfig registry = new RegistryConfig();
		registry.setAddress(PropertyLoader.getProp("dubbo.zookeeper.url"));
		registry.setProtocol("zookeeper");

		// 注意：ReferenceConfig为重对象，内部封装了与注册中心的连接，以及与服务提供方的连接
		// 引用远程服务
		ReferenceConfig<IDubboService> reference = new ReferenceConfig<>();
		// 此实例很重，封装了与注册中心的连接以及与提供者的连接，请自行缓存，否则可能造成内存和连接泄漏
		reference.setApplication(application);
		// 多个注册中心可以用setRegistries()
		reference.setRegistry(registry);
		reference.setInterface(IDubboService.class);
		reference.setVersion("1.0.0");

		// 和本地bean一样使用xxxService
		// 注意：此代理对象内部封装了所有通讯细节，对象较重，请缓存复用
		IDubboService dubboService = reference.get();

		DubboRequest request = new DubboRequest();
		request.setId(19);
		request.setName("jerry");
		System.out.println(dubboService.service(request));
	}
}
