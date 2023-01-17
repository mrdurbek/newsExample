package com.example.newsExample.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.newsExample.service.AuthService;
import com.example.newsExample.service.MyUserDetailsService;

@Component
public class JwtFilter extends OncePerRequestFilter {
	
	@Autowired
	JwtProvider jwtProvider;
	@Autowired
	MyUserDetailsService myUserDetailsService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token = request.getHeader("Authorization");
		if(token!=null && token.startsWith("Bearer")) {
			if(jwtProvider.validateToken(token)) {
				UserDetails userDetails = myUserDetailsService.loadUserByUsername(jwtProvider.getUsername(token));
				UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null , userDetails.getAuthorities());
				SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			}
		}
		filterChain.doFilter(request, response);
	}
	
}
