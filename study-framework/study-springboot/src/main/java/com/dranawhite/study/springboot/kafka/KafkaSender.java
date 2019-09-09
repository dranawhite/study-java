package com.dranawhite.study.springboot.kafka;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author dranawhite
 * @version : KafkaSender.java, v 0.1 2019-09-05 11:23 dranawhite Exp $$
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface KafkaSender {

    @AliasFor(annotation = Component.class)
    String value() default "";
}
