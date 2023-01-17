package com.example.newsExample.payload;

import javax.validation.constraints.NotBlank;

public class PostDto {
	
	@NotBlank
	private String title;
	@NotBlank
	private String text;
	
	public PostDto() {}
	
	public PostDto(String title, String text) {
		super();
		this.title = title;
		this.text = text;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
}
