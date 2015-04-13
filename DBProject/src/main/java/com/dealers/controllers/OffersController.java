package com.dealers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dealers.dao.User;
import com.dealers.dao.UsernameValidationGroup;
import com.dealers.service.OfferService;

@Controller
public class OffersController
{
	@Autowired
	private OfferService service;
	
	@RequestMapping(value = "/dealerproducts",method=RequestMethod.POST)
	public String showPhotos(Model model,@Validated(UsernameValidationGroup.class) User user,BindingResult result) {
		if(result.hasErrors())
		{
			return "selectdealer";
		}
		model.addAttribute("products", service.getOffersByDealer(5));
		return "products";
	}
}
