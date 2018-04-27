package com.test.dubbo.consumer.jmeter;

import com.dranawhite.api.model.Result;
import com.dranawhite.test.jmeter.dubbo.AbstractDubboPerformSampler;
import com.test.dubbo.provider.IDubboService;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liangyq
 * @version [1.0, 2018/4/27 17:41]
 */
public class Consumer extends AbstractDubboPerformSampler {

	private IDubboService dubboService;

	@Override
	public void setupTest(JavaSamplerContext context) {
		ClassPathXmlApplicationContext ctx =
				new ClassPathXmlApplicationContext("applicationContext-dubbo-consumer.xml");
		ctx.start();
		dubboService = ctx.getBean("dubboService", IDubboService.class);
	}

	@Override
	public <T> Result<T> run(JavaSamplerContext context) {
		Result<String> result = dubboService.sayHello();
		return (Result<T>) result;
	}
}
