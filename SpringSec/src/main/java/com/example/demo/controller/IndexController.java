package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.pojo.User;

@RestController
@SessionAttributes("user")
public class IndexController {
	
	private static final Logger log = LoggerFactory.getLogger(IndexController.class);

	
	@GetMapping("/login")
	@ResponseBody
	public String login(User user,Model model) {
		model.addAttribute("user", user);
		return "login success";
	}
	@GetMapping("/join")
	@ResponseBody
	public String join(Model model) {
		return "join success";
	}
	@RequestMapping("/admin")
    @ResponseBody
    public String admin() {
    	return "admin success";
    }
    @ResponseBody
    @GetMapping("/loginout")
    public String loginOut() {
    	return "loginout";
    }
}
