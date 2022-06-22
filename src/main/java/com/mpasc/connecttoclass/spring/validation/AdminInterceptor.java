package com.mpasc.connecttoclass.spring.validation;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class AdminInterceptor implements  HandlerInterceptor{
	private static Logger logger = Logger.getLogger(AdminInterceptor.class.toString());
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception {
		logger.info("Working on this.............");
		return true; 
	}
	
	
	public  void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,@Nullable ModelAndView  modelAndView) throws Exception {
			
			
			
		}
		
		public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,@Nullable Exception ex)throws Exception {
	
			
			
		}

}
