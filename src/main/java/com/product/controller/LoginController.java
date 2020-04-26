package com.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@RequestMapping("/login1")
	public String login() {
		
		System.out.println("login Controller");
		return "loginForm";
	}

}
