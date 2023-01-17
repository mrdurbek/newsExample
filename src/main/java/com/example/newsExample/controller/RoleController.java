package com.example.newsExample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.newsExample.payload.ApiResponse;
import com.example.newsExample.payload.RoleDto;
import com.example.newsExample.service.RoleService;

@RestController
@RequestMapping("/api/role")
public class RoleController {
	
	@Autowired
	RoleService roleService;
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody RoleDto roleDto) {
		ApiResponse apiResponse =  roleService.addRole(roleDto);
		if(apiResponse.getStatus()) {
			return ResponseEntity.ok(apiResponse.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponse.getMessage());
	}
	
}
