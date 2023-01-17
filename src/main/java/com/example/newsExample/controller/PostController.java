package com.example.newsExample.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.newsExample.payload.ApiResponse;
import com.example.newsExample.payload.PostDto;
import com.example.newsExample.service.PostService;

@RestController
@RequestMapping("/api/post")
public class PostController {
	
	@Autowired
	PostService postService;
	
	@PreAuthorize(value = "hasAuthority('ADD_POST')")
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody PostDto postDto){
		ApiResponse apiResponse  = postService.add(postDto);
		if(apiResponse.getStatus()) {
			return ResponseEntity.ok(apiResponse.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponse.getMessage());
	}
	@PreAuthorize(value = "hasAuthority('DELETE_POST')")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable long id){
		ApiResponse apiResponse  = postService.delete(id);
		if(apiResponse.getStatus()) {
			return ResponseEntity.ok(apiResponse.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponse.getMessage());
	}
	@PreAuthorize(value = "hasAuthority('EDIT_POST')")
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@RequestBody PostDto postDto  ,  @PathVariable long id){
		ApiResponse apiResponse  = postService.update(postDto , id);
		if(apiResponse.getStatus()) {
			return ResponseEntity.ok(apiResponse.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponse.getMessage());
	}
}
