package com.example.newsExample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.newsExample.entity.Role;
import com.example.newsExample.payload.ApiResponse;
import com.example.newsExample.payload.RoleDto;
import com.example.newsExample.repository.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	RoleRepository roleRepository;
	
	public ApiResponse addRole(RoleDto roleDto) {
		
		if(roleRepository.existsByName(roleDto.getName())) {
			return new ApiResponse("This role already existed!" , false);
		}
		
		Role role = new Role();
		role.setName(roleDto.getName());
		role.setAuthoritesList(roleDto.getAuthorites());
		
		roleRepository.save(role);
		
		return new ApiResponse("Role has been created." , true);
	}
}
