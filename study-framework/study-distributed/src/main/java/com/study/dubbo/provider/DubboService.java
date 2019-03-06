package com.study.dubbo.provider;

import com.dranawhite.api.builder.ResultBuilder;
import com.dranawhite.api.model.RespEnum;
import com.dranawhite.api.model.Result;
import com.dranawhite.common.exception.request.DranaIllegalRequestException;
import com.dranawhite.common.validate.BeanValidator;

import lombok.extern.slf4j.Slf4j;

/**
 * @author dranawhite
 * @version [1.0, 2018/4/17 15:49]
 */
@Slf4j
public class DubboService implements IDubboService {

    @Override
    public Result<String> service(DubboRequest request) {
        try {
            BeanValidator.validate(request);
            log.info(request.toString());
            return ResultBuilder.buildResult(RespEnum.SUCCESS, "Hello Dubbo!");
        } catch (DranaIllegalRequestException ex) {
            log.error(request.toString());
            return ResultBuilder.buildResult(RespEnum.PARAM_INVALID);
        }
    }
}
