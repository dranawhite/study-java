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
 * @version : KafkaConsumer.java, v 0.1 2019-09-05 14:30 dranawhite Exp $$
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface KafkaConsumer {

    @AliasFor(annotation = Component.class)
    String value() default "";
}
