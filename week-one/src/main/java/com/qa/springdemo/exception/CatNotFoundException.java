package com.qa.springdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "No cat found with the given ID")
public class CatNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3746188167251056083L;

}
