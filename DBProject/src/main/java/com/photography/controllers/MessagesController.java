package com.photography.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.photography.dao.FormValidationGroup;
import com.photography.dao.Message;
import com.photography.service.MessageService;

@Controller
public class MessagesController {

	@Autowired
	private MessageService messageService;

	@RequestMapping(value="/contact")
	public String contact(Model model,Principal principal){
		if(principal!=null){
			model.addAttribute("fromName", principal.getName());
		}
		model.addAttribute("message", new Message());
		return "contact";
	}
	
	@RequestMapping(value="/sendmessage")
	public String contact(Model model,@Validated(FormValidationGroup.class) Message message,BindingResult result){
		
		if(result.hasErrors()){
			return "contact";
		}
		messageService.saveOrUpdate(message);
		return "messagesent";
	}
	
	@RequestMapping(value="/messages")
	public String showMessages(Model model){
		model.addAttribute("messages",messageService.getAllMessages());
		return "messages";
	}
	
}
