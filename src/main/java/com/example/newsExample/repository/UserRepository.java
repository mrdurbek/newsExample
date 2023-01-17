package com.example.newsExample.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.newsExample.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	boolean existsByUsername(String username);
	Optional<User> findByUsername(String username);
}
