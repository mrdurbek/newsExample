package com.example.newsExample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.newsExample.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
	
}
