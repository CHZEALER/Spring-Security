package com.example.demo.Filter;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.demo.pojo.User;

public class MyFilter implements Filter{
	private static final Logger log = LoggerFactory.getLogger(MyFilter.class);


	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		log.info("filter初始化");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		log.info("开始进行过滤处理");
		User user=(User)req.getSession().getAttribute("user");
		if (user==null&&req.getRequestURI().contains("join")) {
			log.info("成功拦截并转发");
			res.sendRedirect("/login");
		}
		else {
			chain.doFilter(request, response);
		}

		
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		log.info("销毁中");
	}

	

}
