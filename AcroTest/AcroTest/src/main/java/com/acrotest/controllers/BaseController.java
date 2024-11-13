package com.acrotest.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.acrotest.utils.ApiResponse;

@CrossOrigin
public class BaseController 
{
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ApiResponse handleValidationExceptions(
	  MethodArgumentNotValidException ex) 
	{
	    Map<String, String> errors = new HashMap();
	    ex.getBindingResult().getAllErrors().forEach((error) -> 
	    {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	    });
	    return new ApiResponse(false, "Invalid Data", 
	    		"Request Data Not Valid.", errors);
	}
}
