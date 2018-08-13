package com.study.spring.beans;

import com.study.spring.beans.bean.Car;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 探究容器级生命周期接口
 * <pre>
 *    ApplicationContext 无需手动添加后置处理器，只要在配置文件中配置即可，容器会通过反射的方式自动调用
 * </pre>
 *
 * @author liangyq 2017/12/18
 */
public class ApplicationContextPro {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext
                ("beans/applicationContext-beans.xml");
        Car car = (Car) ctx.getBean("car");
        car.introduce();
    }

}
