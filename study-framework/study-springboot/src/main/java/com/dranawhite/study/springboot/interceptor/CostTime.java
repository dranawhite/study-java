package com.dranawhite.study.springboot.interceptor;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 统计耗时
 *
 * @see InterfaceCostTimeInterceptor
 *
 * @author dranawhite
 * @version : CostTime.java, v 0.1 2019-07-31 11:16 dranawhite Exp $$
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface CostTime {
}
