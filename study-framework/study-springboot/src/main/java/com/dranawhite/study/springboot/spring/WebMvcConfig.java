package com.dranawhite.study.springboot.spring;

import com.dranawhite.study.springboot.converter.SensitiveDataEncryptConverter;
import com.dranawhite.study.springboot.interceptor.InterfaceCostTimeInterceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.context.request.async.TimeoutCallableProcessingInterceptor;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * 自定义的MVC组件，实现WebMvcConfigurer接口
 *
 * <pre>
 *     corsFilter配置
 *     // 表示允许哪些原始域进行跨域访问
 *     // 添加Access-Control-Allow-Origin响应头
 *     corsConfiguration.addAllowedOrigin("*");
 *     // PUT和DELETE方法，浏览器需要发送OPTIONS请求询问，此处同意访问
 *     // 添加Access-Control-Allow-Methods响应头
 *     corsConfiguration.addAllowedMethod(HttpMethod.PUT);
 *     corsConfiguration.addAllowedMethod(HttpMethod.DELETE);
 *     // 允许发送Cookie
 *     // 添加Access-Control-Allow-Credentials响应头
 *     corsConfiguration.setAllowCredentials(Boolean.TRUE);
 *     // 允许所有的浏览器请求头
 *     // 添加Access-Control-Allow-Headers响应头
 *     corsConfiguration.addAllowedHeader("*");
 *     // 暴露所有响应头信息给客户端
 *     // 添加Access-Control-Expose-Headers响应头
 *     corsConfiguration.addExposedHeader("*");
 *     // 设置OPTIONS请求的最大缓存时间
 *     corsConfiguration.setMaxAge(1800L);
 *
 *     图片: doc/cors/cors.jpg
 * </pre>
 *
 * @author dranawhite
 * @version : WebMvcConfig.java, v 0.1 2019-07-26 16:46 dranawhite Exp $$
 */
@Configuration
@EnableWebMvc
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

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        // 配置SpringBoot异步请求
        configurer.setDefaultTimeout(60000L);
        configurer.setTaskExecutor(getTaskExecutor());
        configurer.registerCallableInterceptors(new TimeoutCallableProcessingInterceptor());
    }

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        // 开启Spring Controller和Service的方法校验
        return new MethodValidationPostProcessor();
    }

//    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.applyPermitDefaultValues();
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedMethod(HttpMethod.PUT);
        corsConfiguration.addAllowedMethod(HttpMethod.DELETE);
        corsConfiguration.setAllowCredentials(Boolean.TRUE);
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.setMaxAge(1800L);
        UrlBasedCorsConfigurationSource configurationSource = new UrlBasedCorsConfigurationSource();
        configurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(configurationSource);
    }

    private ThreadPoolTaskExecutor getTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(20);
        executor.setBeanName("async-request");
        executor.setThreadNamePrefix("Async-Request-");
        executor.initialize();
        return executor;
    }

}
