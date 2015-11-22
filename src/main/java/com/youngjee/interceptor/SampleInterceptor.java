package com.youngjee.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SampleInterceptor extends HandlerInterceptorAdapter {
	
	private static Logger logger = LoggerFactory.getLogger(SampleInterceptor.class);
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		logger.info("<<<<< postHandle postHandle postHandle >>>>>");
		
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("<<<<< preHandle preHandle preHandle  >>>>>");
		
		HandlerMethod method = (HandlerMethod) handler;
		Method methodobj = method.getMethod();
		
		logger.info("preHandler Bean:"+method.getBean());
		logger.info("preHandler Method:"+methodobj);
		
		return true;
	}

}
