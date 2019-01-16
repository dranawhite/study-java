package com.study.spring.core;

import org.springframework.stereotype.Repository;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author dranawhite
 * @version [1.0, 2018/4/21 11:53]
 */
@Repository
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ReposrityBusiness {

	String value();
}
