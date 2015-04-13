package com.dealers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dealers.service.UsersService;

@Controller
public class AdminController {
	
	@Autowired
	private UsersService usersService;
	
}
