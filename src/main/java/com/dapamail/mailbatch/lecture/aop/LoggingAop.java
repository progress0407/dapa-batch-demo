package com.dapamail.mailbatch.lecture.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Aspect
public class LoggingAop {
	
	@Around("execution(* com.dapamail.mailbatch..*(..))")
	public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
		log.info("[aop]________ {} ____________", joinPoint.toString());
		return joinPoint.proceed();
	}

}
