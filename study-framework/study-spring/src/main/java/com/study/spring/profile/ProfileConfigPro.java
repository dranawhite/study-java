package com.study.spring.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author dranawhite 2018/3/19
 */
public class ProfileConfigPro {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.getEnvironment().setActiveProfiles("prod");
		ctx.register(ProfileConfig.class);
		ctx.refresh();
		DeviceInfo deviceInfo = ctx.getBean(DeviceInfo.class);
		System.out.println(deviceInfo.getInfo());
	}

}
