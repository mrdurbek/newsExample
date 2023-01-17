package com.example.newsExample.security;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.example.newsExample.entity.Role;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtProvider {
	
	private String secretKey = "qwerty09876@#$^&*";
	private long expireDate = 1000*60*60*24*7;
	
	public String generateToken(String username , Role role) {
		
		String token = Jwts	
					.builder()
					.setSubject(username)
					.setIssuedAt(new Date())
					.setExpiration(new Date(System.currentTimeMillis()+expireDate))
					.claim("role", role.getName())
					.signWith(SignatureAlgorithm.HS512, secretKey)
					.compact();
		
		return token;
	}
	
	public boolean validateToken(String token) {
		try {
			Jwts	
					.parser()
					.setSigningKey(secretKey)
					.parseClaimsJws(token);
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}
	
	public String getUsername(String token) {
		
		String username = Jwts
				.parser()
				.setSigningKey(secretKey)
				.parseClaimsJws(token)
				.getBody()
				.getSubject();
		
		return username;
	}
}
