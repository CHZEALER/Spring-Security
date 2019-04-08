package com.example.demo.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.example.demo.pojo.User;

public class AdminFilter implements Filter {
	private static Logger log=LoggerFactory.getLogger(AdminFilter.class);
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		log.info("AdminFilter初始化中");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		log.info("AdminFilter开始进行过滤处理");
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		User user=(User)req.getSession().getAttribute("user");
		if("admin".equals(user.getUsername())){
			chain.doFilter(request, response);
		}else {
			log.info("AdminFilter成功拦截并转发");
			}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		log.info("销毁中");
	}

}
