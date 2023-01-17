package com.example.newsExample.payload;

public class ApiResponse {
	
	private String message;
	private boolean status;
	private Object object;
	
	public ApiResponse() {}
	
	public ApiResponse(String message, boolean status) {
		super();
		this.message = message;
		this.status = status;
	}
	
	
	public ApiResponse(String message, boolean status, Object object) {
		super();
		this.message = message;
		this.status = status;
		this.object = object;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	
	
}
