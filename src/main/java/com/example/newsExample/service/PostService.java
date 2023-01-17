package com.example.newsExample.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.newsExample.entity.Post;
import com.example.newsExample.payload.ApiResponse;
import com.example.newsExample.payload.PostDto;
import com.example.newsExample.repository.PostRepository;

@Service
public class PostService {
	
	@Autowired
	PostRepository postRepository;
	
	public ApiResponse add(PostDto postDto) {
		Post post = new Post();
		post.setTitle(postDto.getTitle());
		post.setText(postDto.getText());
		
		post.setUrl(postDto.getText());
		
		postRepository.save(post);
		return new ApiResponse("Post has been created" , true);
	}
	
	public ApiResponse delete(long id) {
		try {
			postRepository.deleteById(id);
			return new ApiResponse("Post has been deleted" , true);
		} catch (Exception e) {
			return new ApiResponse(e.getMessage() , false);
		}
	}
	
	public ApiResponse update(PostDto postDto , long id) {
		Optional<Post> optionalPost =  postRepository.findById(id);
		if(optionalPost.isEmpty()) {
			return new ApiResponse("Not Found" , false);
		}
		Post post = optionalPost.get();
		post.setTitle(postDto.getTitle());
		post.setText(postDto.getText());
		post.setUrl(postDto.getTitle());
		postRepository.save(post);
		
		return new ApiResponse("Post has been updated" , true); 
	}
}
