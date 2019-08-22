package com.study.spring.aop.annotation;

import com.study.spring.aop.Apolopy;
import com.study.spring.aop.ApolopyImpl;
import com.study.spring.aop.Person;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liangyuquan
 * @version : AopService.java, v 0.1 2019-08-21 18:28 liangyuquan Exp $$
 */
@Aspect
@Configuration
public class AopService {

    @DeclareParents(value = "com.study.spring.aop.Person", defaultImpl = ApolopyImpl.class)
    private Apolopy apolopy;

    @Autowired
    private Person person;

    public void say() {
  
        person.say();
    }

    @Bean
    public Apolopy apolopy() {
        return new ApolopyImpl();
    }

    @Bean
    public Person person() {
        return new Person();
    }
}
