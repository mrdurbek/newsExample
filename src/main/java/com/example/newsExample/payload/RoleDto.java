package com.example.newsExample.payload;

import java.util.List;

import com.example.newsExample.entity.enums.Authorites;

public class RoleDto {
	
	private String name;
	private  List<Authorites> authorites;
	
	public RoleDto() {}
	
	public RoleDto(String name, List<Authorites> authorites) {
		super();
		this.name = name;
		this.authorites = authorites;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Authorites> getAuthorites() {
		return authorites;
	}

	public void setAuthorites(List<Authorites> authorites) {
		this.authorites = authorites;
	}
	
	
}
