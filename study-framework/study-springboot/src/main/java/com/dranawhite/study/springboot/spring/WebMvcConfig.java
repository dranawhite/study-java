package com.dranawhite.study.springboot.spring;

import com.dranawhite.study.springboot.converter.SensitiveDataEncryptConverter;
import com.dranawhite.study.springboot.interceptor.InterfaceCostTimeInterceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * 自定义的MVC组件，实现WebMvcConfigurer接口，无需使用@EnableWebMvc注解
 *
 * @author dranawhite
 * @version : WebMvcConfig.java, v 0.1 2019-07-26 16:46 dranawhite Exp $$
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加拦截器，应用于所有Path
        registry.addInterceptor(new InterfaceCostTimeInterceptor()).order(1).addPathPatterns("/**");
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        // URL取消截取.号之前的路径(原URL只会截取点号之前的路径，忽略点号之后的内容)
        configurer.setUseSuffixPatternMatch(false);
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        int insertIndex = converters.size();
        for (int i = 0, size = converters.size(); i < size; i++) {
            if (converters.get(i) instanceof MappingJackson2HttpMessageConverter) {
                insertIndex = i;
                break;
            }
        }
        converters.add(insertIndex, new SensitiveDataEncryptConverter());
    }

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        // 开启Spring Controller和Service的方法校验
        return new MethodValidationPostProcessor();
    }
}
