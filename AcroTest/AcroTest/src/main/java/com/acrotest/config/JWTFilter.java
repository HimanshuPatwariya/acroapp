package com.acrotest.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.acrotest.entities.User;
import com.acrotest.services.UserService;
import com.acrotest.utils.ApiResponse;
import com.google.gson.Gson;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JWTFilter extends OncePerRequestFilter
{
	@Autowired
	private JWTBuilder jwtBuilder;
	
	@Autowired
	private UserService userService;
	
	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException 
	{
		
		return request.getServletPath().contains("/acro") || 
				request.getServletPath().contains("/swagger-ui/") || 
				request.getServletPath().contains("/v2/api-docs");
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, 
			HttpServletResponse response, 
			FilterChain filterChain)
			throws ServletException, IOException 
	{
		Gson gson = new Gson();
		response.setHeader("Content-Type", "application/json");
		final String requestToken = request.getHeader("Authorization");
		System.out.println(requestToken);
		if(requestToken==null || requestToken.length()==0) 
		{
			ApiResponse res = new ApiResponse(false, "Token not Found !",null);
			response.getWriter().write(gson.toJson(res));
		}else 
		{
			try {
				System.out.println(jwtBuilder.isExpiry(requestToken));
				if(jwtBuilder.isExpiry(requestToken)) 
				{
					ApiResponse res = new ApiResponse(false, "Token Expired !",null);
					response.getWriter().write(gson.toJson(res));
				}else 
				{
					int userid = Integer.parseInt(jwtBuilder.getUserIdFromToken(requestToken));
					User user = userService.getById(userid);
					if(user==null) 
					{
						ApiResponse res = new ApiResponse(false, "Token Corrupted !",null);
						response.getWriter().write(gson.toJson(res));
					}else 
					{
						UsernamePasswordAuthenticationToken auth = 
								new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
						auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
						SecurityContextHolder.getContext().setAuthentication(auth);
						filterChain.doFilter(request, response);
					}
				}
			}catch(Exception ex) {
				ApiResponse res = new ApiResponse(false, "Token Expired or Corrupted !",null);
				response.getWriter().write(gson.toJson(res));
			}
		}
	}
}
