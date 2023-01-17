package com.example.newsExample.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.example.newsExample.entity.template.AbstractEntity;

@Entity
public class Comment extends AbstractEntity{

	@Column(nullable = false , columnDefinition = "text")
	private String text;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Post post;
	
	public Comment() {}

	public Comment(String text, Post post) {
		super();
		this.text = text;
		this.post = post;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
	
	
}
