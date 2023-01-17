package com.example.newsExample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.newsExample.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
