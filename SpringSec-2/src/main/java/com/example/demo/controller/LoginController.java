package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@Controller
public class LoginController {
	@GetMapping("/login")
	public String home() {
		return "login";
	}
	
	//主页请求映射
		@GetMapping({"","/","/index"})
		public String index() {
			return "/index";
		}

}
