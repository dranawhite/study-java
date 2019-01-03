package com.study.dubbo.provider;

import com.dranawhite.api.builder.ResultBuilder;
import com.dranawhite.api.model.RespEnum;
import com.dranawhite.api.model.Result;
import com.dranawhite.common.util.BeanValidator;
import com.dranawhite.common.util.StringUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @author liangyq
 * @version [1.0, 2018/4/17 15:49]
 */
@Slf4j
public class DubboService implements IDubboService {

	@Override
	public Result<String> service(DubboRequest request) {
		if(StringUtil.isEmpty(BeanValidator.validate(request))) {
			log.info(request.toString());
			return ResultBuilder.buildResult(RespEnum.SUCCESS, "Hello Dubbo!");
		} else {
			log.error(request.toString());
			return ResultBuilder.buildResult(RespEnum.PARAM_INVALID);
		}
	}
}
