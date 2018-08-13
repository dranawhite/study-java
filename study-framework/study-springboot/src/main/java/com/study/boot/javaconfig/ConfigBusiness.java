/**
 * ymm56.com Inc. Copyright (c) 2013-2018 All Rights Reserved.
 */
package com.study.boot.javaconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 配置业务类
 *
 * @author liangyq
 * @version $Id: ConfigBusiness.java, v 0.1 2018-08-13 17:46 liangyq Exp $$
 */
@Service
public class ConfigBusiness {

    @Autowired
    private ConfigService configService;

    public void print() {
        configService.print();
    }

}
