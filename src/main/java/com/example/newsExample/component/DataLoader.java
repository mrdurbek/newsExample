package com.example.newsExample.component;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.newsExample.entity.Role;
import com.example.newsExample.entity.User;
import com.example.newsExample.entity.enums.Authorites;
import com.example.newsExample.repository.RoleRepository;
import com.example.newsExample.repository.UserRepository;
import com.example.newsExample.utils.AppConstants;

@Component
public class DataLoader implements CommandLineRunner {
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Value("${spring.datasource.intialization-mode}")
	private String intializationMode;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Running");
		
		if(intializationMode.equals("always")) {
		
			Authorites[] authorites = Authorites.values();
			
			Role role1 = new Role();
			role1.setName(AppConstants.ADMIN);
			role1.setAuthoritesList(Arrays.asList(authorites));
			Role admin = roleRepository.save(role1);
			
			Role role2 = new Role();
			role2.setName(AppConstants.USER);
			role2.setAuthoritesList(Arrays.asList(Authorites.ADD_COMMENT,
												  Authorites.DELETE_MY_COMMENT,
												  Authorites.EDIT_COMMENT));
			Role user = roleRepository.save(role2);
			
			User user1 = new User();
			user1.setFirstname("Admin");
			user1.setLastname("Admin");
			user1.setUsername("admin");
			user1.setPassword(passwordEncoder.encode("admin12345"));
			user1.setRole(admin);
			userRepository.save(user1);
			
			User user2 = new User();
			user2.setFirstname("User");
			user2.setLastname("User");
			user2.setUsername("user");
			user2.setPassword(passwordEncoder.encode("user12345"));
			user2.setRole(user);
			userRepository.save(user2);
		}
	}	
}
