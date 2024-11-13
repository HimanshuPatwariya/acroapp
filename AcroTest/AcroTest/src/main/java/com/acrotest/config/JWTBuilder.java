package com.acrotest.config;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import com.acrotest.entities.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTBuilder 
{
	public static final long JWT_TOKEN_VALIDITY = 1000*60*5000;
	private String secret="RkqzhzEjo6xuKFPb4jztckDGFz6vLw3+jXuHeWZ9iFINRpflDeJ1VadCMrCuDS0WJWwHRwveR15UzaEiFyDFP6zZ4synqT+DrPaWXJpQ9qum1HB1ORBN/dvLALGE2zDc2uHSEoLxeXEGVQYp";

	public String generateToken(User user) 
	{
		Map<String, Object> claims = new HashMap();
		return doGenerateToken(claims, user.getUid()+"");
	}

	private String doGenerateToken(Map<String, Object> claims, String subject) 
	{
		SecretKey secretKey = Keys.hmacShaKeyFor(secret.getBytes());
	    String token = Jwts.builder()
	            .signWith(secretKey, SignatureAlgorithm.HS256)
	            .setHeaderParam("typ", "jwt")
	            .setIssuer("acropilis")
	            .setAudience("user")
	            .setSubject(subject)
	            .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY))
	            .compact();
	    return token;
	}
	
	public Boolean isExpiry(String token) 
	{
		return !isTokenExpired(token);
	}
	
	private Boolean isTokenExpired(String token) {
		final Date expiration = getClaimFromToken(token, Claims::getExpiration);
		System.out.println(expiration.getTime());
		System.out.println(new Date().getTime());
		return expiration.after(new Date());
	}
	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) 
	{		
		return claimsResolver.apply(Jwts.parser().setSigningKey(secret.getBytes())
				.parseClaimsJws(token).getBody());
	}
	
	public String getUserIdFromToken(String token) 
	{
		return getClaimFromToken(token, Claims::getSubject);
	}
	
}
