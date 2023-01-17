package com.example.newsExample.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.newsExample.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	
	Optional<Role> findByName(String name);
	
	boolean existsByName(String name);
}
