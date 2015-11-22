package com.youngjee.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SampleAdvice {
	private static final Logger logger = LoggerFactory.getLogger(SampleAdvice.class);
	
//	@Before("execution(* com.youngjee.service.MessageService*.*(..))")
	public void startLog(JoinPoint jp) {
		logger.info("<<<<<<<<SampleAdvice startLog start>>>>>>>");
		logger.info(Arrays.toString(jp.getArgs()));
		logger.info("<<<<<<<<SampleAdvice startLog end>>>>>>>");
	}
	
//	@Around("execution(* com.youngjee.service.MessageService*.*(..) )")
	public Object timeLog(ProceedingJoinPoint pjp) throws Throwable {
		logger.info("<<<<<<<<SampleAdvice timeLog start>>>>>>>");

		long startTime = System.currentTimeMillis();
		
		logger.info(Arrays.toString(pjp.getArgs()));
		
		long endTime = System.currentTimeMillis();
		logger.info(pjp.getSignature().getName()+" : "+(endTime-startTime));
		
		logger.info("<<<<<<<<SampleAdvice timeLog end>>>>>>>");
		
		return  pjp.proceed();
		
	}
	
//	@After("execution(* com.youngjee.service.MessageService*.*(..))")
	public void afterLog(JoinPoint jp) {
		logger.info("<<<<<<<<SampleAdvice afterLog start>>>>>>>");
		logger.info(Arrays.toString(jp.getArgs()));
		logger.info("<<<<<<<<SampleAdvice afterLog end>>>>>>>");
	}
}
