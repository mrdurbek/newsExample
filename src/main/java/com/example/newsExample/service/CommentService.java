package com.example.newsExample.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.newsExample.entity.Comment;
import com.example.newsExample.entity.Post;
import com.example.newsExample.payload.ApiResponse;
import com.example.newsExample.payload.CommentDto;
import com.example.newsExample.repository.CommentRepository;
import com.example.newsExample.repository.PostRepository;

@Service
public class CommentService {
	
	@Autowired
	CommentRepository commentRepository;
	@Autowired
	PostRepository postRepository;
	
	public ApiResponse add(CommentDto commentDto) {
		Comment comment = new Comment();
		comment.setText(commentDto.getText());
		Optional<Post> optionalPost = postRepository.findById(commentDto.getPostId());
		if(optionalPost.isEmpty()) {
			return new ApiResponse("Post doesn't exist" , false);
		}
		comment.setPost(optionalPost.get());
		commentRepository.save(comment);
		return new ApiResponse("Comment has been created." , true);
	}
	
	public ApiResponse delete(long id) {
		try {
			commentRepository.deleteById(id);
			return new ApiResponse("Post has been deleted" , true);
		} catch (Exception e) {
			return new ApiResponse(e.getMessage() , false);
		}
	}
	
	public ApiResponse update(CommentDto commentDto , long id) {
		Optional<Comment> optionalComment =  commentRepository.findById(id);
		if(optionalComment.isEmpty()) {
			return new ApiResponse("Not Found" , false);
		}
		Comment comment = optionalComment.get();
		comment.setText(commentDto.getText());
		commentRepository.save(comment);
		
		return new ApiResponse("Post has been updated" , true); 
	}
}
