package com.dealers.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dealers.domain.Offer;
import com.dealers.service.DealerService;

@Controller
public class DealerController
{
	@Autowired
	private DealerService service;
	
	@RequestMapping(value = "/buyOffer", method = RequestMethod.GET)
	public String showOffersForProducts(@RequestParam int dealerId,@RequestParam int productId, Principal principal, Offer offer)
	{
		System.out.println(offer);
		service.makeDeal(dealerId,productId,principal.getName());
		return "donedeal";
	}
}
