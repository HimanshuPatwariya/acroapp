package com.acrotest.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FacReg 
{
	@NotNull(message = "Name Can't be Null")
	@NotEmpty(message = "Empty Name Not Allowed")
	private String name;
	
	@NotNull(message = "Email Can't be Null")
	@NotEmpty(message = "Empty Email Not Allowed")
	private String email;
	
	@NotNull(message = "Password Can't be Null")
	@NotEmpty(message = "Empty Password Not Allowed")
	private String password;
	
	@NotNull(message = "Phone Can't be Null")
	@NotEmpty(message = "Empty Phone Not Allowed")
	private String phone;
	
	@NotNull(message = "Fac ID Can't be Null")
	private Integer facid;
}
