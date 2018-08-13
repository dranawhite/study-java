package com.study.spring.core;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import lombok.Getter;

/**
 * <pre>
 *     使用XmlBeanDefinitionReader和DefaultListableBeanFactory加载Bean
 * </pre>
 *
 * @author dranawhite 2017/12/18
 * @version 1.0
 */
public class DefaultBeanLoaderPro {

    @Getter
    private DefaultListableBeanFactory factory;

    public <T> T getBean(String name) {
        return (T) factory.getBean(name);
    }

    public <T> T getBean(Class<T> clz) {
        return factory.getBean(clz);
    }

    private void init(String path) {
        //加载person.xml文件
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource res = resolver.getResource(path);

        //BeanDefinition载入
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(res);
        this.factory = factory;
    }

    public static void main(String[] args) {
        DefaultBeanLoaderPro pro = new DefaultBeanLoaderPro();
        pro.init("classpath:core/applicationContext-core-scan.xml");
        PersonReposrity pn = pro.getBean("PersonR");
        System.out.println("PN = " + pn.toString());
    }

}
