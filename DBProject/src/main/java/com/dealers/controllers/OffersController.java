package com.dealers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dealers.domain.Offer;
import com.dealers.domain.User;
import com.dealers.service.DealsService;
import com.dealers.service.OfferService;
import com.dealers.service.ProductService;
import com.dealers.validation.FormValidationGroup;
import com.dealers.validation.UsernameValidationGroup;

@Controller
public class OffersController
{
	@Autowired
	private OfferService offerService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private DealsService dealerService;

	@RequestMapping(value = "/dealeroffers", method = RequestMethod.POST)
	public String showOffersForDealer(Model model,
			@Validated(UsernameValidationGroup.class) User user,
			BindingResult result)
	{
		if (result.hasErrors())
		{
			return "selectdealer";
		}
		model.addAttribute("offers", offerService.getOffersByDealer(5));
		return "offers";
	}

	@RequestMapping(value = "/productoffers", method = RequestMethod.GET)
	public String showOffersForProducts(Model model,@RequestParam int productId)
	{
		model.addAttribute("offer", new Offer());
		model.addAttribute("offers", offerService.getOffersForProduct(productId));
		return "offers";
	}
	

	@RequestMapping(value="/addOffer",method=RequestMethod.GET)
	public String addOffer(Model model){
		model.addAttribute("offer", new Offer());
		model.addAttribute("products", productService.getAllProducts());
		model.addAttribute("dealers", dealerService.getAllDealers());
		return "addOffer";
	}
	
	@RequestMapping(value="/addOffer")
	public String saveOffer(Model model,@Validated(FormValidationGroup.class) Offer offer,BindingResult result){
			offerService.saveOffer(offer);
			return "donedeal";
	}
}
