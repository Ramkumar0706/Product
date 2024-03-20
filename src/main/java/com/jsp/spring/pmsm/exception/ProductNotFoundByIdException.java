package com.jsp.spring.pmsm.exception;

public class ProductNotFoundByIdException extends RuntimeException{
	private String message;

	public ProductNotFoundByIdException(String message) {
		super();
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}

}
