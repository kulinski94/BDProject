package com.dealers.controllers;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {
	
	@ExceptionHandler(DataAccessException.class)
	public String handleDatabaseException(DataAccessException ex) {
		ex.printStackTrace();
		return "error";
	}
	
	@ExceptionHandler(Exception.class)
	public String allException(Exception ex) {
		ex.printStackTrace();
		return "error";
	}
	
	@ExceptionHandler(AccessDeniedException.class)
	public String handleAccessException(AccessDeniedException ex) {
		ex.printStackTrace();
		return "denied";
	}
	
	@ExceptionHandler(Throwable.class)
	public String handleAllExceptions(Throwable ex) {
		ex.printStackTrace();
		return "error";
	}
	
	@ExceptionHandler(DuplicateKeyException.class)
	public String duplicateKeyException(DuplicateKeyException ex) {
		ex.printStackTrace();
		return "duplicate";
	}
}
