package com.product.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.product.model.ProductCategory;
import com.product.model.ProductMaster;
import com.product.model.ProductSubCategory;
import com.product.service.CategoryService;
import com.product.service.ProductService;
import com.product.service.SubcategoryService;

@Controller
public class CartController {
	
	@Autowired
	ProductService productService;
	

	@Autowired
	CategoryService categoryService;

	@Autowired
	SubcategoryService SubcategoryService;
	
	@RequestMapping("/cart/{id}")
	public String addToCart(@PathVariable("id")String pro, HttpServletRequest request,ModelMap map) {
		
		
		List<String> pros=(List<String>) request.getSession().getAttribute("MY_PROS");
		
		if (pros == null) {
			pros = new ArrayList<>();
			request.getSession().setAttribute("MY_PROS", pros);
		}
		pros.add(pro);
		request.getSession().setAttribute("MY_PROS", pros);
		
		System.out.println("list of orders "+pros.size());
		
		ProductMaster proMaster=productService.getProductByName(pro);
		
		System.out.println("add to cart msg ->"+proMaster.getProductSubCat());
		
		return "redirect:/"+proMaster.getProductSubCat();
		
	}

}
