package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.product.jpa.CountryJpa;
import com.product.model.Country;
import com.product.model.State;

@Controller
public class CountryController {
	
	@Autowired
	CountryJpa repo;
	
	/*
	 * @RequestMapping("/cont")
	 * 
	 * @ResponseBody public List<Country> getCountry() {
	 * 
	 * return repo.findAll(); }
	 */
	
	@RequestMapping("/cont")
	public String getCountryform(ModelMap map) {
		map.addAttribute("country", new Country());
		return "country";
	}
	
	@RequestMapping(value = "/cont",method = RequestMethod.POST)
	public String getCountryReg(@ModelAttribute("country")Country country,ModelMap map) {
		
		repo.save(country);
		map.addAttribute("country", new Country());
		return "country";
	}
	
	@RequestMapping(value = "/state")
	public String StateForm(ModelMap map) {
		
		List<Country> countries=repo.findAll();
		
		map.addAttribute("countries", countries);		
		map.addAttribute("state", new State());
		return "state";
	}
	/*
	 * @RequestMapping("/cont/{name}")
	 * 
	 * @ResponseBody public List<Country> getCountryIname(@PathVariable("name")
	 * String name) {
	 * 
	 * return repo.findByName(name); }
	 */

}
