package com.study.dubbo.consumer.jmeter;

import com.dranawhite.api.model.Result;
import com.dranawhite.common.util.StringUtil;
import com.dranawhite.test.jmeter.java.AbstractJavaPerformSampler;
import com.study.dubbo.provider.DubboRequest;
import com.study.dubbo.provider.IDubboService;
import lombok.extern.slf4j.Slf4j;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dranawhite
 * @version [1.0, 2018/4/27 17:41]
 */
@Slf4j
public class Consumer extends AbstractJavaPerformSampler {

	private IDubboService dubboService;

	@Override
	public void setupTest(JavaSamplerContext context) {
		ClassPathXmlApplicationContext ctx =
				new ClassPathXmlApplicationContext("applicationContext-dubbo-consumer.xml");
		ctx.start();
		dubboService = ctx.getBean("dubboService", IDubboService.class);
	}

	@Override
	public Map<String, String> getArguments() {
		Map<String, String> args = new HashMap<>(4);
		args.put("id", "19");
		args.put("name", "Ketty");
		return args;
	}

	@Override
	public <T> Result<T> run(JavaSamplerContext context) {
		Result<String> result = dubboService.service(buildRequest(context));
		return (Result<T>) result;
	}

	private DubboRequest buildRequest(JavaSamplerContext context) {
		DubboRequest request = new DubboRequest();
		String id = context.getParameter("id");
		String name = context.getParameter("name");
		if (StringUtil.isNotEmpty(id)) {
			request.setId(Integer.parseInt(id));
		}
		request.setName(name);
		return request;
	}
}
