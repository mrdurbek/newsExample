package com.example.newsExample.payload;

import javax.validation.constraints.NotBlank;

public class RegisterDto {
	
	@NotBlank(message = "This area cannot be empty!")
	private String firstname;
	@NotBlank(message = "This area cannot be empty!")
	private String lastname;
	@NotBlank(message = "This area cannot be empty!")
	private String username;
	@NotBlank(message = "This area cannot be empty!")
	private String password;
	
	public RegisterDto() {}
	
	public RegisterDto(String firstname, String lastname, String username, String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
