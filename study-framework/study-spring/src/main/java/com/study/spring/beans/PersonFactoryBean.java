package com.study.spring.beans;

import com.study.spring.beans.bean.IPerson;
import com.study.spring.beans.bean.Person;

import org.springframework.beans.factory.FactoryBean;

/**
 * <pre>
 *     FactoryBean的实现类，如果在配置文件中，通过Class实例化，则通过getBean()获取时，实际上获取到的是
 * FactoryBean.getObject()返回的对象；
 * </pre>
 *
 * @author liangyq 2017/12/22
 */
public class PersonFactoryBean implements FactoryBean {

    private  IPerson person = new Person();

    @Override
    public Object getObject() throws Exception {
        return this.person;
    }

    @Override
    public Class<?> getObjectType() {
        return this.person.getClass();
    }

    @Override
    public boolean isSingleton() {
        //如果是单例，则Spring会把person放入单例缓存池中
        return false;
    }
}
