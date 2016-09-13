package com.hand.Util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanFactory {
	private static final ApplicationContext context;
	private SpringBeanFactory(){}
	static{
		context=new ClassPathXmlApplicationContext("SpringConfig/applicationContext.xml");
	}
	public static ApplicationContext getBeanFactory(){
		return context;
	}
}
