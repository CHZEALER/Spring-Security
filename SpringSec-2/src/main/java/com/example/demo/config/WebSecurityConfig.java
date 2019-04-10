package com.example.demo.config;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;


@EnableWebSecurity//(debug = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
    private CustomLogoutSuccessHandler customLogoutSuccessHandler;
	
	@Bean
	public UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User.withUsername("1").password("1").roles("USER").build());
		manager.createUser(User.withUsername("2").password("2").roles("ADMIN").build());
		manager.createUser(User.withUsername("3").password("3").roles("DBA").build());
		manager.createUser(User.withUsername("4").password("4").roles("DBA","ADMIN").build());
		
		return manager;
	}
	
	@Bean
    public CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler() {
        return new CustomAuthenticationSuccessHandler();
    }
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("123456").roles();
	    auth.inMemoryAuthentication().withUser("user").password("123456").roles();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
			.antMatchers("/resources/**", "/signup", "/about").permitAll()                  
			.antMatchers("/admin/**").hasRole("ADMIN")                                      
			.antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
				.anyRequest().authenticated()
				.and().csrf().disable();
		
		http.formLogin()
			.loginPage("/login")
			.usernameParameter("un")//修改usename参数为前端页面的name参数：un
			.passwordParameter("psd")//修改password参数为前端页面的name参数：psd
			.successHandler(customAuthenticationSuccessHandler())
			.permitAll();
		
		http
		.logout()                                                                
			.logoutUrl("/my/logout")//无此项默认为logout，匹配前端的/logout
			.logoutSuccessUrl("/index")//注销之后跳转的URL
			.logoutSuccessHandler(customLogoutSuccessHandler)     
			.deleteCookies("JSESSIONID");
		;
		/*http
		.authorizeRequests()
		.antMatchers("/resources/**", "/signup", "/about").permitAll()                  
		.antMatchers("/admin/**").hasRole("ADMIN")                                      
		.antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
			.anyRequest().authenticated()
			.and()
		.formLogin()
			.and()
		.httpBasic();*/

	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		super.configure(web);
	}

}
