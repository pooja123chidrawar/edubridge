package com.springboot.exception;

import org.springframework.http.HttpHeaders;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.*;


	
@ControllerAdvice
public class ValidationHandler extends ResponseEntityExceptionHandler{

		@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
		@ExceptionHandler(ResourceNotFoundException.class) 
		protected ResponseEntity<Object> handleUserDefinedException(ResourceNotFoundException ex1){
			System.out.println("validation handler" +ex1.getMessage());
			Map<String,String> errors1=new HashMap<String ,String>();
			errors1.put("errorMessage",ex1.getMessage());
			return new ResponseEntity<Object> (errors1,HttpStatus.NOT_FOUND) ;
		}
		
		@Override
		protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
				HttpHeaders headers,HttpStatus status,WebRequest request){
		
			Map<String,String> errors=new HashMap<String ,String>();
			ex.getBindingResult().getAllErrors().forEach((error)->{
				String fieldName=((FieldError) error).getField();
				String message=error.getDefaultMessage();
				errors.put(fieldName, message);
			});
			return new ResponseEntity<Object> (errors,HttpStatus.BAD_REQUEST);
		}
}
