package com.study.spring.beans;

import com.study.spring.beans.bean.IPerson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 探究Bean的自动映射和自动注入@Autowired
 * <pre>
 *     Autowired注解默认是byType的方式来映射的。
 * </pre>
 *
 * @author dranawhite 2017/12/19
 * @version 1.0
 */
public class AutowiredPro {

    /**
     * 如果Autowired映射到多个Bean，则使用Qualifier指定组件的name
     */
    @Autowired
    @Qualifier("personImpl")
    private IPerson person;

    /**
     * 扫描容器内所有的实现了IPerson接口的Bean注入，顺序按照@Order指定
     */
    @Autowired
    private List<IPerson> personList;

    @Override
    public String toString() {
        return person.sleep();
    }

    public void print() {
        for (IPerson person : personList) {
            System.out.println(person.sleep());
        }
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext
                ("beans/applicationContext-person.xml");
        AutowiredPro pro = ctx.getBean("pro", AutowiredPro.class);
        System.out.println(pro.toString());
        System.out.println("=============");
        pro.print();
    }

}
