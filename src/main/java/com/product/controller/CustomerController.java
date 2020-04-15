package com.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.product.model.Customer;

@Controller
public class CustomerController {
	
	@RequestMapping("/cust")
	public String formCustomer(ModelMap map) {
		
		map.addAttribute("customer", new Customer());
		return "customer";
	}

}
