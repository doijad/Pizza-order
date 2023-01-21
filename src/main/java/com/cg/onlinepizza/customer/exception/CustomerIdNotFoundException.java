package com.cg.onlinepizza.customer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerIdNotFoundException extends Exception{

	public CustomerIdNotFoundException(String message) {
		super(message);
	}
	

}
