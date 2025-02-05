package com.educandoweb.course.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	// Construtor
	
	public ResourceNotFoundException(Object id) {
		super("Resource not found. Id " + id); // msg padrão da exceção personalizada
	}

}
