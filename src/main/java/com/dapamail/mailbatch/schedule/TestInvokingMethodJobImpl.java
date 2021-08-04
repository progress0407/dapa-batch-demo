package com.dapamail.mailbatch.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.MethodInvokingFactoryBean;

public class TestInvokingMethodJobImpl extends MethodInvokingFactoryBean {
	
	@Autowired
	TestJobMethode myTestJobMethod;
	
	TestInvokingMethodJobImpl() {
		this.setTargetObject(myTestJobMethod);
		this.setTargetMethod("justPrintLog");
	}
	
	@Override
	public void setTargetObject(Object targetObject) {
		super.setTargetObject(targetObject);
	}
	
	@Override
	public void setTargetMethod(String targetMethod) {
		setTargetMethod(targetMethod);
	}
}
