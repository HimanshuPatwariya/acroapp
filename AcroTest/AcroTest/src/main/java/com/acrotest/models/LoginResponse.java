package com.acrotest.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse 
{
	private String name;
	private String token;
	private String role;
}
