/**
 * ymm56.com Inc. Copyright (c) 2013-2018 All Rights Reserved.
 */
package com.study.boot.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author liangyq
 * @version $Id: Config.java, v 0.1 2018-08-13 18:04 liangyq Exp $$
 */
@Configuration
public class Config {

    @Conditional(LinuxCondition.class)
    @Bean(value = "linux")
    public String getLinuxOs() {
        return "Linux";
    }

    @Conditional(WinCondition.class)
    @Bean(value = "windows")
    public String getWindowsOs() {
        return "Windows";
    }
}
