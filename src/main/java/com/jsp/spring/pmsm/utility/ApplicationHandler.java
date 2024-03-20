package com.jsp.spring.pmsm.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.spring.pmsm.exception.ProductNotFoundByIdException;
import com.jsp.spring.pmsm.exception.ProductNotFoundException;

@RestControllerAdvice
public class ApplicationHandler {

	private ErrorStructure<String> errorStructure;


	public ApplicationHandler(ErrorStructure<String> errorStructure) {
		super();
		this.errorStructure = errorStructure;
	}


	@ExceptionHandler(ProductNotFoundByIdException.class)
	public ResponseEntity<ErrorStructure<String>> productNotFoundByIdException(ProductNotFoundByIdException ex)
	{
		return ResponseEntity.ok(errorStructure.setErrorStatuscode(HttpStatus.NOT_FOUND.value())
				.setErrorMessage(ex.getMessage())
				.setErrorMessage("product Object With the Given id doesnot exist"));
	}

	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorStructure<String>> productNotFoundException(ProductNotFoundException ex)
	{
		return ResponseEntity.ok(errorStructure.setErrorStatuscode(HttpStatus.NOT_FOUND.value())
				.setErrorMessage(ex.getMessage())
				.setErrorMessage("product doesnot exists"));
	}
}
