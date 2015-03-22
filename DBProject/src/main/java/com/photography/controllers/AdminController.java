package com.photography.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.photography.dao.Album;
import com.photography.dao.FormValidationGroup;
import com.photography.service.PhotosService;
import com.photography.service.UsersService;

@Controller
public class AdminController {
	
	@Autowired
	private PhotosService photoService;
	
	@Autowired
	private UsersService usersService;

	@RequestMapping(value = "/uploadalbum", method = RequestMethod.POST)
	public String uploadAlbum(Model model,
			@Validated(FormValidationGroup.class) Album album,
			BindingResult result) {

		if (result.hasErrors()) {
			model.addAttribute("users", usersService.getAllUsers());
			return "newalbum";
			
		}
		try {
				photoService.uploadAlbum(album);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "albumuploaded";
	}

	@RequestMapping(value = "/newalbum")
	public String showUploadPage(Model model) {
		model.addAttribute("users", usersService.getAllUsers());
		model.addAttribute("album", new Album());
		return "newalbum";
	}
	
}
