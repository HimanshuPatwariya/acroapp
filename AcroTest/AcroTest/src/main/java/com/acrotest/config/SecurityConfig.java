package com.acrotest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig 
{
	@Autowired
	private JWTFilter jwtFilter;
	
	@Bean
	public PasswordEncoder passwordEncoder() 
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception 
	{
		return http.getSharedObject(AuthenticationManagerBuilder.class).build();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception 
	{
		http.csrf(t -> t.disable())
				.authorizeHttpRequests((requests) -> requests.requestMatchers("/", "/acro/**","/swagger-ui/**","/v2/api-docs/**")
					.permitAll()
					.requestMatchers("/auth/admin/**").hasRole("ADMIN")
					.requestMatchers("/auth/faculty/**").hasRole("FACULTY")
					.requestMatchers("/auth/student/**").hasRole("STUDENT")
					.anyRequest()
					.authenticated())
				.exceptionHandling(t->t.accessDeniedPage("/acro/accessDenied"))
				.addFilterBefore(jwtFilter, 
						UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}
}
