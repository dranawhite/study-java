package com.study.spring.beans;

import com.study.spring.beans.processor.CarBeanPostProcessor;
import com.study.spring.beans.processor.CarInstantiationAwareBeanPostProcessor;
import com.study.spring.beans.bean.Car;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 *  探究Bean级生命周期
 *  <pre>
 *      BeanFactory必须手动指定后置处理器，而ApplicationContext会通过反射自动映射，只要配置中配置即可
 *  </pre>
 *
 */
public class BeanLifeCycle {

    private void lifeCycleInBeanFactory() {

        //①下面两句装载配置文件并启动容器
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource res = resolver.getResource("classpath:beans/beanFactory-beans.xml");

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(res);

        //②向容器中注册MyBeanPostProcessor后处理器, ConfigurableBeanFactory提供
        factory.addBeanPostProcessor(new CarBeanPostProcessor());

        //③向容器中注册MyInstantiationAwareBeanPostProcessor后处理器，ConfigurableBeanFactory提供
        factory.addBeanPostProcessor(new CarInstantiationAwareBeanPostProcessor());

        //④第一次从容器中获取car，将触发容器实例化该Bean，这将引发Bean生命周期方法的调用。
        Car car1 = (Car) factory.getBean("car");
        car1.introduce();
        car1.setColor("红色");

        //⑤第二次从容器中获取car，直接从缓存池中获取
        Car car2 = (Car) factory.getBean("car");

        //⑥查看car1和car2是否指向同一引用
        System.out.println("car1==car2:" + (car1 == car2));
        //⑦关闭容器
        factory.destroySingletons();
    }

    public static void main(String[] args) {
        BeanLifeCycle beanLifeCycle = new BeanLifeCycle();
        beanLifeCycle.lifeCycleInBeanFactory();
    }
}
