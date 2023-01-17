package com.example.newsExample.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.newsExample.entity.enums.Authorites;
import com.example.newsExample.entity.template.AbstractEntity;

@Entity
public class Role extends AbstractEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false , unique = true)
	private String name;
	
	@ElementCollection
	@Enumerated(EnumType.STRING)
	private List<Authorites> authoritesList;
	
	public Role() {}
	
	public Role(Long id, String name, List<Authorites> authoritesList) {
		super();
		this.id = id;
		this.name = name;
		this.authoritesList = authoritesList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Authorites> getAuthoritesList() {
		return authoritesList;
	}

	public void setAuthoritesList(List<Authorites> authoritesList) {
		this.authoritesList = authoritesList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
