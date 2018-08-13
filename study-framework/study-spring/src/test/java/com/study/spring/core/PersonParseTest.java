package com.study.spring.core;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author dranawhite 2017/11/7
 * @version 1.0
 */
public class PersonParseTest {

    @Test
    public void testPerson() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:core/applicationContext-core.xml");
        Person person = (Person) ctx.getBean("person");
        System.out.println(person.toString());
        Assert.assertNotNull(person);
    }

    /**
     * 代码的方式加载Bean
     * @throws IOException
     */
    @Test
    public void testPersonLoader() throws IOException {
        DefaultBeanLoaderPro pro = new DefaultBeanLoaderPro();
        Person pn = pro.getBean("classpath:core/applicationContext-core.xml");
        Assert.assertNotNull(pn);
    }

    /**
     * 使用Java类的方式配置bean
     */
    @Test
    public void testPersonAnnoLoader() {
        AnnoConfigurableLoaderPro pro = new AnnoConfigurableLoaderPro();
        Person pn = pro.getBean("personAnno", Person.class);
        Assert.assertNotNull(pn);
    }
}
