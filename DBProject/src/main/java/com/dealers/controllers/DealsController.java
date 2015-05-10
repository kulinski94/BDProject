package com.dealers.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dealers.domain.DealsReportRequest;
import com.dealers.domain.Offer;
import com.dealers.service.DealsService;
import com.dealers.service.ProductService;
import com.dealers.service.UsersService;

@Controller
public class DealsController
{
	@Autowired
	private DealsService dealsService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private UsersService userService;
	
	
	@RequestMapping(value = "/buyOffer", method = RequestMethod.GET)
	public String showOffersForProducts(@RequestParam int dealerId,@RequestParam int productId, Principal principal, Offer offer)
	{
		System.out.println(offer);
		dealsService.makeDeal(dealerId,productId,principal.getName());
		return "donedeal";
	}
	
	@RequestMapping(value = "/dealsReport", method = RequestMethod.GET)
	public String showAllDeals(Model model)
	{
		setModelAttributes(model);
		DealsReportRequest requst = new DealsReportRequest();
		model.addAttribute("dealsReportRequest", requst);
		model.addAttribute("deals", dealsService.getDeals(requst));
		return "deals";
	}
	
	@RequestMapping(value = "/dealsReport", method = RequestMethod.POST)
	public String showDealsWithFilters(Model model, DealsReportRequest request)
	{
		setModelAttributes(model);
		model.addAttribute("deals", dealsService.getDeals(request));
		model.addAttribute("dealsReportRequest", new DealsReportRequest());
		return "deals";
	}

	private void setModelAttributes(Model model)
	{
		model.addAttribute("products", productService.getAllProducts());
		model.addAttribute("dealers", dealsService.getAllDealers());
		model.addAttribute("clients", userService.getAllUsers());
	}
}
