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



public class LoginOutFilter implements Filter {
	private static Logger log=LoggerFactory.getLogger(LoginOutFilter.class);
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		log.info("LoginOutFilter初始化中");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		log.info("LoginOutFilter开始进行过滤处理");
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		User user=(User)req.getSession().getAttribute("user");
		if(user==null) {
			log.info("没有用户登录");
			response.getWriter().write("no user login");
		}else {
			req.getSession().removeAttribute("user");
			log.info("LoginOutFilter成功");
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		log.info("销毁中");
	}

}
