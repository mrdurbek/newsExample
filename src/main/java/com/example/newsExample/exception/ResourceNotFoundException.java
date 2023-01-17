package com.example.newsExample.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
	
	private final String resourceName;
	private final String resourceField;
	private final Object reesourceValue;
	
	public ResourceNotFoundException(String resourceName, String resourceField, Object reesourceValue) {
		super();
		this.resourceName = resourceName;
		this.resourceField = resourceField;
		this.reesourceValue = reesourceValue;
	}

	public String getResourceName() {
		return resourceName;
	}

	public String getResourceField() {
		return resourceField;
	}

	public Object getReesourceValue() {
		return reesourceValue;
	}

	
	
}
