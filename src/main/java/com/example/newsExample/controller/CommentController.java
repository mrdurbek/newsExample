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
import com.example.newsExample.payload.CommentDto;
import com.example.newsExample.service.CommentService;

@RestController
@RequestMapping("/api/comment")
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	@PreAuthorize(value = "hasAuthority('ADD_COMMENT')")
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody CommentDto commentDto){
		ApiResponse apiResponse  = commentService.add(commentDto);
		if(apiResponse.getStatus()) {
			return ResponseEntity.ok(apiResponse.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponse.getMessage());
	}
	@PreAuthorize(value = "hasAnyAuthority('DELETE_COMMENT' , 'DELETE_MY_COMMNET')")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable long id){
		ApiResponse apiResponse  = commentService.delete(id);
		if(apiResponse.getStatus()) {
			return ResponseEntity.ok(apiResponse.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponse.getMessage());
	}
	
	@PreAuthorize(value = "hasAuthority('EDIT_COMMENT')")
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@RequestBody CommentDto commentDto  ,  @PathVariable long id){
		ApiResponse apiResponse  = commentService.update(commentDto , id);
		if(apiResponse.getStatus()) {
			return ResponseEntity.ok(apiResponse.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CONFLICT).body(apiResponse.getMessage());
	}
}
