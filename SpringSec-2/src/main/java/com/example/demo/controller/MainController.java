package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	@GetMapping("/home")
	public String home() {
		return "this is home";
	}
	
	@GetMapping("/a")
	public String a() {
		return "this is a";
	}
	
	
}
