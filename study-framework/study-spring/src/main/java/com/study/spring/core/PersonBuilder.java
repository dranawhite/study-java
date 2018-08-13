package com.study.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <pre>
 *     通过Java类的形式配置Bean，类似于XML配置，注解配置以及Groovy配置
 * </pre>
 *
 * @author dranawhite 2017/12/18
 * @version 1.0
 */
@Configuration
public class PersonBuilder {

    @Bean("personAnno")
    public Person buildPerosn() {
        Person pn = new Person();
        pn.setAge(15);
        pn.setId("01");
        pn.setName("test");
        return pn;
    }

}
