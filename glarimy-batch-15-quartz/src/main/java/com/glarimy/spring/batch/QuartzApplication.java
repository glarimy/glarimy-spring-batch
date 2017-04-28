package com.glarimy.spring.batch;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class QuartzApplication {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("spring/context.xml");
	}
}
