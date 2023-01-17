package com.example.newsExample.payload;

public class CommentDto {
	
	private String text;
	private long postId;
	
	public CommentDto() {}
	
	public CommentDto(String text, long postId) {
		super();
		this.text = text;
		this.postId = postId;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public long getPostId() {
		return postId;
	}
	public void setPostId(long postId) {
		this.postId = postId;
	}
	
	
}
