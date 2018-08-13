package com.study.spring.beans.processor;

import com.study.spring.beans.bean.Car;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author liangyq 2017/12/18
 */
public class CarBeanPostProcessor implements BeanPostProcessor {

    private final String CAR = "car";

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        if (beanName.equals(CAR)) {
            Car car = (Car) bean;
            if (car.getMaxSpeed() >= 200) {
                System.out.println(
                        "调用BeanPostProcessor.postProcessAfterInitialization()，将maxSpeed调整为200。");
                car.setMaxSpeed(200);
            }
        }
        return bean;

    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        if (beanName.equals(CAR)) {
            Car car = (Car) bean;
            if (car.getColor() == null) {
                System.out.println(
                        "调用BeanPostProcessor.postProcessBeforeInitialization()，color为空，设置为默认黑色。");
                car.setColor("黑色");
            }
        }
        return bean;
    }
}
