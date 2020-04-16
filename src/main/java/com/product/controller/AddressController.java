package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.product.model.Address;
import com.product.model.Country;
import com.product.model.State;
import com.product.service.AddressService;
import com.product.service.CustomerService;

@Controller
public class AddressController {
	
	@Autowired
	AddressService addressServie;
	
	@Autowired
	CustomerService custService;
	
	@RequestMapping("/address")
	public String formAddress(ModelMap map) {
		
		
		List<Country> countries=addressServie.getCountries();
		map.addAttribute("countries", countries);
		map.addAttribute("add", new Address());
		return "address";
	}
	
	@RequestMapping(value = "/address",method = RequestMethod.POST)
	public String regAddress(@ModelAttribute("add")Address address,ModelMap map) {
		
		custService.saveAddress(address);
		
		
		map.addAttribute("add", new Address());
		return "address";
	}
	
	@RequestMapping("/address/{id}")
	public String getStates(@PathVariable("id")Integer countryId,ModelMap map) {
		
		
		List<State> countries=addressServie.getStatesByCountryId(countryId);
		map.addAttribute("countries", countries);
		map.addAttribute("add", new Address());
		return "address";
	}

}
