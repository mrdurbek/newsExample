package com.example.newsExample.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.newsExample.entity.Role;
import com.example.newsExample.entity.User;
import com.example.newsExample.exception.ResourceNotFoundException;
import com.example.newsExample.payload.ApiResponse;
import com.example.newsExample.payload.LoginDto;
import com.example.newsExample.payload.RegisterDto;
import com.example.newsExample.repository.RoleRepository;
import com.example.newsExample.repository.UserRepository;
import com.example.newsExample.security.JwtProvider;
import com.example.newsExample.utils.AppConstants;

@Service
public class AuthService {
	
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	JwtProvider jwtProvider;
	
	public ApiResponse register(RegisterDto registerDto) {
		
		if(userRepository.existsByUsername(registerDto.getUsername())) {
			return new ApiResponse("This username is already created! " , false);
		}
		
		Optional<Role> optionalRole = roleRepository.findByName(AppConstants.USER);
		if(optionalRole.isEmpty()) {
			throw new ResourceNotFoundException("Role", "name", "User");
		}
		User user = new User();
		user.setFirstname(registerDto.getFirstname());
		user.setLastname(registerDto.getLastname());
		user.setUsername(registerDto.getUsername());
		user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
		user.setRole(optionalRole.get());
		user.setEnabled(true);
		userRepository.save(user);
		return new ApiResponse("Successfully registered." , true);
	}
	
	public ApiResponse login(LoginDto loginDto) {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
			User user = userRepository.findByUsername(loginDto.getUsername()).orElseThrow(() -> new UsernameNotFoundException("Not Found"));
			String token = jwtProvider.generateToken(loginDto.getUsername() , user.getRole());
			return new ApiResponse(token , true); 
		} catch (BadCredentialsException e) {
			return new ApiResponse(e.getMessage() , false);
		}
	}
	
}
