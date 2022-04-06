package com.revature.exceptions;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(FruitNotFoundException.class)
	public ResponseEntity<String> handleFruitNotFoundException(FruitNotFoundException e){
		LOG.warn("Fruit not found exception was handled.", e);
		return new ResponseEntity<>("Fruit doesn't exist", HttpStatus.NOT_FOUND); 
	}
	
	
}
