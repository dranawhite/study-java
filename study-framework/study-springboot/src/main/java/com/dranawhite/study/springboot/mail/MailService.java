package com.dranawhite.study.springboot.mail;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

/**
 * 邮件服务
 *
 * @author dranawhite
 * @version : MailService.java, v 0.1 2019-07-26 11:41 dranawhite Exp $$
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface MailService {

    @AliasFor(annotation = Component.class)
    String value() default "";

}
