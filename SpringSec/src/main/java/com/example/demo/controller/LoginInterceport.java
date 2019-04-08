package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.pojo.User;



public class LoginInterceport implements HandlerInterceptor {
    private static Logger log=LoggerFactory.getLogger(LoginInterceport.class);
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("LoginInterceport preHandle");
		User user=(User)request.getSession().getAttribute("user");
		if(user==null&&request.getRequestURI().contains("join")) {
			log.info("成功拦截并转发");
			response.sendRedirect(request.getContextPath()+"/login");
		    return false;
		}
		return true;
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("LoginInterceport postHandle");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("LoginInterceport afterCompletion");
	}


}
