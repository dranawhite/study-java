package com.dranawhite.study.springboot.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 自定义的MVC组件，实现WebMvcConfigurer接口，无需使用@EnableWebMvc注解
 *
 * @author dranawhite
 * @version : WebMvcConfig.java, v 0.1 2019-07-26 16:46 dranawhite Exp $$
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
}
