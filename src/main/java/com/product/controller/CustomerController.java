package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.product.model.Customer;
import com.product.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerService custService;
	
	@RequestMapping("/cust")
	public String formCustomer(ModelMap map) {
		
		System.out.println("CustomerController.formCustomer()");
		
		map.addAttribute("customer", new Customer());
		return "registration";
	}
	
	@RequestMapping(value = "/cust",method = RequestMethod.POST)
	public String registerCustomer(@ModelAttribute()Customer customer,ModelMap map) {
		
		System.out.println(customer);
		custService.registerCustomer(customer);
		
		map.addAttribute("customer", new Customer());
		return "registration";
	}
	

	@RequestMapping("/customers")
	public String getCustomers(ModelMap map) {
		
		List<Customer> customers=custService.getCustomers();
		
		System.out.println(customers);
		
		map.addAttribute("customers", customers);
		return "customersList";
	}

}
