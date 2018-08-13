package com.study.spring.beans.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * <pre>
 *  调用CarBeanFactoryPostProcessor.postProcessBeanFactory()！
 *  调用Car()构造函数。
 *  调用setBrand()设置属性。
 *  调用BeanNameAware.setBeanName()。
 *  调用BeanFactoryAware.setBeanFactory()。
 *  调用BeanPostProcessor.postProcessBeforeInitialization()，color为空，设置为默认黑色。
 *  调用InitializingBean.afterPropertiesSet()。
 *  调用myInit()，将maxSpeed设置为240。
 *  调用BeanPostProcessor.postProcessAfterInitialization()，将maxSpeed调整为200。
 *  introduce:brand:奇瑞QQ/color:黑色/maxSpeed:200
 * </pre>
 */
public class CarBeanFactoryPostProcessor implements BeanFactoryPostProcessor{

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory bf) throws BeansException {
		BeanDefinition bd = bf.getBeanDefinition("car");
		bd.getPropertyValues().addPropertyValue("brand", "奇瑞QQ");
		System.out.println("调用CarBeanFactoryPostProcessor.postProcessBeanFactory()！");
	}

}
