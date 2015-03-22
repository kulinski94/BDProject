package com.photography.controllers;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.photography.dao.FormValidationGroup;
import com.photography.dao.Photo;
import com.photography.dao.Order;
import com.photography.dao.User;
import com.photography.dao.UsernameValidationGroup;
import com.photography.service.PhotosService;
import com.photography.service.UsersService;

@Controller
public class PhotosController {

	@Autowired
	private PhotosService photoService;
	
	@Autowired
	private UsersService usersService;

	@RequestMapping(value = "/photos")
	public String showPhotos(Model model,Principal principal) {
		User user = usersService.getUser(principal.getName());
		if(user.getAuthority().equals("ROLE_ADMIN")){
			model.addAttribute("users", usersService.getAllUsers());
			model.addAttribute("user",new User());
			return "selectuser";
		}
		List<Photo> photos = photoService.getPhotosByUser(principal.getName());
		model.addAttribute("photos", photos);
		model.addAttribute("order", new Order());
		return "selectphotos";
	}
	

	@RequestMapping(value = "/userphotos",method=RequestMethod.POST)
	public String showPhotos(Model model,@Validated(UsernameValidationGroup.class) User user,BindingResult result) {
		if(result.hasErrors())
		{
			return "selectuser";
		}
		List<Photo> photos = photoService.getPhotosByUser(user.getUsername());
		model.addAttribute("photos", photos);
		model.addAttribute("order", new Order());
		return "photos";
	}
	
	
	@RequestMapping(value = "/submitphotos",method=RequestMethod.POST)
	public String submitPhotos(Model model,@Validated(FormValidationGroup.class) Order order,BindingResult result) {
		if(result.hasErrors()){
			return "selectphotos";
		}
		photoService.selectPhotos(order.getSelectedIds());
		System.out.println(order);
		return "photosordered";
	}
	
	
}
