package com.dealers.controllers;

import java.security.Principal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dealers.domain.Category;
import com.dealers.domain.Product;
import com.dealers.service.ProductService;

@Controller
public class ProductsController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/products/{category}")
	public String showOffersByCategory(Model model,Principal principal,@PathVariable Category category) {
			Map<Product, Integer> productOffers = productService.getAllProductsOffers(category);
			
			model.addAttribute("products", productOffers);
			model.addAttribute("categories", Category.values());
			return "products";
	}
	
	@RequestMapping(value = "/products")
	public String showOffers(Model model,Principal principal) {
			Map<Product, Integer> productOffers = productService.getAllProductsOffers();
			
			model.addAttribute("products", productOffers);
			model.addAttribute("categories", Category.values());
			return "products";
	}
	

	
//	@RequestMapping(value = "/submitphotos",method=RequestMethod.POST)
//	public String submitPhotos(Model model,@Validated(FormValidationGroup.class) Order order,BindingResult result) {
//		if(result.hasErrors()){
//			return "selectphotos";
//		}
//		productService.selectProduct(order.getSelectedIds());
//		System.out.println(order);
//		return "photosordered";
//	}
	
	
}
