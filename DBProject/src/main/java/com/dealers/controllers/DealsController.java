package com.dealers.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dealers.domain.Offer;
import com.dealers.service.DealsService;

@Controller
public class DealsController
{
	@Autowired
	private DealsService service;
	
	@RequestMapping(value = "/buyOffer", method = RequestMethod.GET)
	public String showOffersForProducts(@RequestParam int dealerId,@RequestParam int productId, Principal principal, Offer offer)
	{
		System.out.println(offer);
		service.makeDeal(dealerId,productId,principal.getName());
		return "donedeal";
	}
	
	@RequestMapping(value = "/dealsReport", method = RequestMethod.GET)
	public String showOffersForProducts(Model model)
	{
		model.addAttribute("deals", service.getAllDeals());
		return "deals";
	}
}
