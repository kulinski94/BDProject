package com.dealers.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dealers.dao.User;
import com.dealers.dao.UsernameValidationGroup;
import com.dealers.domain.Offer;
import com.dealers.domain.Product;
import com.dealers.service.OfferService;

@Controller
public class OffersController
{
	@Autowired
	private OfferService service;

	@RequestMapping(value = "/dealeroffers", method = RequestMethod.POST)
	public String showOffersForDealer(Model model,
			@Validated(UsernameValidationGroup.class) User user,
			BindingResult result)
	{
		if (result.hasErrors())
		{
			return "selectdealer";
		}
		model.addAttribute("offers", service.getOffersByDealer(5));
		return "offers";
	}

	@RequestMapping(value = "/productoffers", method = RequestMethod.GET)
	public String showOffersForProducts(Model model,@RequestParam int productId)
	{
		model.addAttribute("offer", new Offer());
		model.addAttribute("offers", service.getOffersForProduct(productId));
		return "offers";
	}

	@RequestMapping(value = "/buyOffer", method = RequestMethod.GET)
	public String showOffersForProducts(@RequestParam int dealerId,@RequestParam int productId, Principal principal, Offer offer)
	{
		System.out.println(offer);
		service.makeDeal(dealerId,productId,principal.getName());
		return "donedeal";
	}
}
