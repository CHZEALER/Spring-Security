package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {
	@GetMapping("/resources/1")
	public String home() {return "resources 1";}
	@GetMapping("/resources/2")
	public String home2() {return "resources 2";}
	@GetMapping("/admin/1")
	public String admin() {return "admin 1";}
	@GetMapping("/admin/2")
	public String admin2() {return "admin 2";}
	@GetMapping("/db/1")
	public String db() {return "db 1";}
	@GetMapping("/db/2")
	public String db2() {return "db 2";}
}
