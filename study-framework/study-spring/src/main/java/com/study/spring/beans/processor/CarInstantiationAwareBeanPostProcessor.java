package com.study.spring.beans.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import java.beans.PropertyDescriptor;

public class CarInstantiationAwareBeanPostProcessor
        extends InstantiationAwareBeanPostProcessorAdapter {

    private final String CAR = "car";

    @Override
    public Object postProcessBeforeInstantiation(Class beanClass, String beanName)
            throws BeansException {
        if (CAR.equals(beanName)) {
            System.out.println(
                    "InstantiationAwareBeanPostProcessor.postProcessBeforeInstantiation");
        }
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName)
            throws BeansException {
        if (CAR.equals(beanName)) {
            System.out.println("InstantiationAwareBeanPostProcessor.postProcessAfterInstantiation");
        }
        return true;
    }

    @Override
    public PropertyValues postProcessPropertyValues(
            PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName)
            throws BeansException {
        if (CAR.equals(beanName)) {
            System.out.println("InstantiationAwareBeanPostProcessor.postProcessPropertyValues");
        }
        return pvs;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        return bean;
    }
}
