package com.dealers.controllers;

import java.security.Principal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dealers.domain.Category;
import com.dealers.domain.Product;
import com.dealers.domain.ProductOffersStatistic;
import com.dealers.service.ProductService;
import com.dealers.validation.FormValidationGroup;

@Controller
public class ProductsController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/products/{category}")
	public String showOffersByCategory(Model model,Principal principal,@PathVariable Category category) {
			Map<Product, ProductOffersStatistic> productOffers = productService.getAllProductsOffers(category);
			
			model.addAttribute("products", productOffers);
			model.addAttribute("categories", Category.values());
			return "products";
	}
	
	@RequestMapping(value = "/products")
	public String showOffers(Model model,Principal principal) {
			Map<Product, ProductOffersStatistic> productOffers = productService.getAllProductsOffers();
			
			model.addAttribute("products", productOffers);
			model.addAttribute("categories", Category.values());
			return "products";
	}
	
	@RequestMapping(value="/addProduct",method=RequestMethod.GET)
	public String addProduct(Model model){
		model.addAttribute("product", new Product());
		model.addAttribute("categories", Category.values());
		return "addProduct";
	}
	
	@RequestMapping(value="/addProduct")
	public String saveProduct(Model model,@Validated(FormValidationGroup.class) Product product,BindingResult result){
		System.out.println(product);
		productService.saveProduct(product);
		return "donedeal";
	}
}
