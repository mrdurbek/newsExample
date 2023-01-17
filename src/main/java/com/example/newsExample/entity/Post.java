package com.example.newsExample.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.example.newsExample.entity.template.AbstractEntity;

@Entity
public class Post extends AbstractEntity{
	
	@Column(nullable = false , columnDefinition = "text")
	private String title;
	
	@Column(nullable = false , columnDefinition = "text")
	private String text;
	
	@Column(nullable = false , columnDefinition = "text")
	private String url;
	
	public Post() {}

	public Post(String title, String text, String url) {
		super();
		this.title = title;
		this.text = text;
		this.url = url;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
