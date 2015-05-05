package com.dealers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dealers.dao.FormValidationGroup;
import com.dealers.dao.Message;
import com.dealers.domain.Product;
import com.dealers.service.UsersService;

@Controller
public class AdminController {
	
	@Autowired
	private UsersService usersService;
}
