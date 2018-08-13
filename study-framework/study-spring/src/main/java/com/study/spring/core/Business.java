package com.study.spring.core;

import org.springframework.stereotype.Component;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Business注解
 *
 * <pre>
 *     用Componet标注即可
 * </pre>
 *
 * @author liangyq
 * @version [1.0, 2018/4/21 11:41]
 */
@Component
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Business {

	String value();
}
