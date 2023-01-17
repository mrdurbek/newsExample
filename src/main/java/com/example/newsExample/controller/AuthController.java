package com.example.newsExample.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.newsExample.payload.ApiResponse;
import com.example.newsExample.payload.LoginDto;
import com.example.newsExample.payload.RegisterDto;
import com.example.newsExample.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	AuthService authService;
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@Valid @RequestBody RegisterDto registerDto){
		ApiResponse apiResponse = authService.register(registerDto);
		if(apiResponse.getStatus()) {
			return ResponseEntity.ok(apiResponse.getMessage());
		}
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body("Error occured!");
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody LoginDto loginDto){
		ApiResponse apiResponse = authService.login(loginDto);
		if(apiResponse.getStatus()) {
			return ResponseEntity.ok(apiResponse.getMessage());
		}
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponse.getMessage());
	}
}
