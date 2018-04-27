package com.test.dubbo.provider;

import com.dranawhite.api.builder.ResultBuilder;
import com.dranawhite.api.model.RespEnum;
import com.dranawhite.api.model.Result;

/**
 * @author liangyq
 * @version [1.0, 2018/4/17 15:49]
 */
public class DubboService implements IDubboService {

	@Override
	public Result<String> sayHello() {
		return ResultBuilder.buildResult(RespEnum.SUCCESS, "Hello Dubbo!");
	}
}
