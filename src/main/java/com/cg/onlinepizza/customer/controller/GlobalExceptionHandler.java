package com.cg.onlinepizza.customer.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cg.onlinepizza.customer.exception.CustomerIdNotFoundException;
import com.cg.onlinepizza.customer.exception.ErrorInformation;
import com.cg.onlinepizza.customer.exception.InvalidCustomerException;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ResponseBody
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = { CustomerIdNotFoundException.class })
	public ErrorInformation handleConflict(CustomerIdNotFoundException e, HttpServletRequest req) {
		String msg = e.getMessage();
		String uri = req.getRequestURI().toString();
		LocalDateTime dt = LocalDateTime.now();
		ErrorInformation response = new ErrorInformation(uri, msg, dt);
		return response;
	}

	@ResponseBody
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = { (InvalidCustomerException.class )})
	public ErrorInformation handleConflict(InvalidCustomerException e, HttpServletRequest req) {
		String msg = e.getMessage();
		String uri = req.getRequestURI().toString();
		LocalDateTime dt = LocalDateTime.now();
		ErrorInformation response = new ErrorInformation(uri, msg, dt);
		return response;
	}
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody
	@ExceptionHandler(value = { MethodArgumentNotValidException.class })
	public ErrorInformation handleValidationError(MethodArgumentNotValidException ex, HttpServletRequest req) {
		String msg = "validation faild";
		FieldError error = ex.getFieldError();
		if (error != null)
			msg = error.getDefaultMessage();
		LocalDateTime dt = LocalDateTime.now();
		return new ErrorInformation(req.getRequestURI(), msg,dt);

	}

	@ResponseBody
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = { Exception.class })
	public ErrorInformation handleConflict(Exception e, HttpServletRequest req) {
		String msg = e.getMessage();
		String uri = req.getRequestURI().toString();
		LocalDateTime dt = LocalDateTime.now();
		ErrorInformation response = new ErrorInformation(uri, msg, dt);
		return response;
	}
	
}
