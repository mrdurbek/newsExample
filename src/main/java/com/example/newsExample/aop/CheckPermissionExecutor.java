package com.example.newsExample.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.example.newsExample.entity.User;
import com.example.newsExample.exception.ForbiddenException;

@Component
@Aspect
public class CheckPermissionExecutor {
	
	@Before(value = "@annotation(checkPermission)")
	public void CheckUserPermissionMethod(CheckPermission checkPermission) {
		 User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 boolean exist = false; 
		 for (GrantedAuthority authority : user.getAuthorities()) {
			if(authority.getAuthority().equals(checkPermission.value())) {
				exist=true;
			}
		}
		 
		if(!exist) {
			throw new ForbiddenException(checkPermission.value(), "Forbidden");
		}
	}
}
