package com.study.spring.aop;

import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author dranawhite 2017/8/17
 * @version 1.0
 */
public class PersonTest {

    @Test
    public void testSay_beforeAndAfter() {
        System.out.println("---------测试编程式前置通知和后置通知----------");
        //创建代理工厂
        ProxyFactory proxyFactory = new ProxyFactory();
        //射入目标类对象
        proxyFactory.setTarget(new Person());
        //添加前置增强
        proxyFactory.addAdvice(new PersonBeforeAdvice());
        //添加后置增强
        proxyFactory.addAdvice(new PersonAfterAdvice());
        //从代理工厂中获取代理
        Person person = (Person) proxyFactory.getProxy();
        //执行代理方法
        person.say();
    }

    @Test
    public void testSay_around() {
        System.out.println("---------测试编程式环绕通知--------------------");
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new Person());
        proxyFactory.addAdvice(new PersonAroundAdvice());
        Person person = (Person) proxyFactory.getProxy();
        person.say();
        person.sayGoodMorning();
        person.sayGoodEvening();
    }

    @Test
    public void testSay_around_xml() {
        System.out.println("---------测试XML式环绕通知---------------------");
        ApplicationContext ctx = new ClassPathXmlApplicationContext
                ("aop/applicationContext-introduction.xml");
        Person person = (Person) ctx.getBean("proxyFactoryBean");
        person.say();
        person.sayGoodMorning();
        person.sayGoodEvening();
    }

    @Test(expected = NullPointerException.class)
    public void testSay_throw() {
        System.out.println("---------测试编程式异常抛出通知----------------");
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new Person());
        proxyFactory.addAdvice(new PersonThrowAdvice());
        Person person = (Person) proxyFactory.getProxy();
        person.sayNull();
    }

    @Test
    public void testSay_introduction_xml() {
        System.out.println("---------测试XML式引入通知---------------------");
        ApplicationContext ctx = new ClassPathXmlApplicationContext
                ("aop/applicationContext-introduction.xml");
        Person person = (Person) ctx.getBean("proxyFactoryBean");
        person.say();
        Apolopy apolopy = (Apolopy) person;
        apolopy.sayAgain();
    }

    @Test
    public void testSay_aspect_introduction() {
        System.out.println("---------测试Aspect引入通知--------------------");
        ApplicationContext ctx = new ClassPathXmlApplicationContext
                ("aop/applicationContext-aspectanno.xml");
        Apolopy apolopy = (Apolopy) ctx.getBean("person");
        apolopy.sayAgain();
    }

    @Test
    public void testSay_advisor_xml() {
        System.out.println("---------测试XML式切点通知---------------------");
        ApplicationContext ctx = new ClassPathXmlApplicationContext
                ("aop/applicationContext-advisor.xml");
        Person person = (Person) ctx.getBean("proxyAdvisorFactoryBean");
        person.say();
        person.sayGoodMorning();
        person.sayGoodEvening();
    }

    @Test
    public void testSay_autopoint_xml() {
        System.out.println("---------测试XML式自动代理切点通知--------------");
        ApplicationContext ctx = new ClassPathXmlApplicationContext
                ("aop/applicationContext-autopoint.xml");
        Person person = (Person) ctx.getBean("person");
        person.say();
        person.sayGoodMorning();
        person.sayGoodEvening();
    }

    @Test
    public void testSay_auto_xml() {
        System.out.println("---------测试XML式自动代理通知-----------------");
        ApplicationContext ctx = new ClassPathXmlApplicationContext
                ("aop/applicationContext-auto.xml");
        Person person = (Person) ctx.getBean("person");
        person.say();
        person.sayGoodMorning();
        person.sayGoodEvening();
    }

    @Test
    public void testSay_annotation() {
        System.out.println("---------测试Aspect编程式注解通知--------------");
        ApplicationContext ctx = new ClassPathXmlApplicationContext
                ("aop/applicationContext-aspectanno.xml");
        Person person = (Person) ctx.getBean("person");
        person.sayTag();
        person.say();
    }

    @Test
    public void testSay_aspectj() {
        System.out.println("---------测试Aspect编程式切点通知--------------");
        ApplicationContext ctx = new ClassPathXmlApplicationContext
                ("aop/applicationContext-aspectanno.xml");
        Person person = (Person) ctx.getBean("person");
        person.say();
        person.sayGoodMorning();
        person.sayGoodEvening();
    }

    @Test
    public void testSay_aspectj_xml() {
        System.out.println("---------测试Aspect配置式切点通知--------------");
        ApplicationContext ctx = new ClassPathXmlApplicationContext
                ("aop/applicationContext-aspect.xml");
        Person person = (Person) ctx.getBean("person");
        person.say();
        person.sayGoodMorning();
        person.sayGoodEvening();
    }

}
