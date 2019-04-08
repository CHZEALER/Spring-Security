package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.example.demo.Filter.*;


@SpringBootApplication
public class SpringSecApplication {
	@Bean
    public FilterRegistrationBean setFilter2() {
  	  FilterRegistrationBean filterBean=new FilterRegistrationBean();
  	  filterBean.setFilter(new AdminFilter());
  	  filterBean.addUrlPatterns("/admin");
  	  filterBean.setOrder(9);
  	  return filterBean;
    }
	
	
	@Bean
	public FilterRegistrationBean setFilter() {
		FilterRegistrationBean filterBean = new FilterRegistrationBean();
		filterBean.setFilter(new MyFilter());
		filterBean.setName("MyFilter");
		filterBean.setOrder(6);
		filterBean.addUrlPatterns("/*");
		
		return filterBean;
	}
	
	
	
     @Bean
     public FilterRegistrationBean setFilter3() {
   	  FilterRegistrationBean filterBean=new FilterRegistrationBean();
   	  filterBean.setFilter(new LoginOutFilter());
   	  filterBean.addUrlPatterns("/loginout");
   	  filterBean.setOrder(3);
   	  return filterBean;
     }
     @Bean
     public FilterRegistrationBean setFilter4() {
   	  FilterRegistrationBean filterBean=new FilterRegistrationBean();
   	  filterBean.setFilter(new EncodeFilter());
   	  filterBean.addUrlPatterns("/*");
   	  filterBean.setOrder(0);
   	  return filterBean;
     }

	public static void main(String[] args) {
		SpringApplication.run(SpringSecApplication.class, args);
	}

}
