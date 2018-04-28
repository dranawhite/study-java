package com.test.dubbo.provider;

import com.dranawhite.api.model.Result;

/**
 * @author liangyq
 * @version [1.0, 2018/4/17 15:49]
 */
public interface IDubboService {

	Result<String> service(DubboRequest request);

}
