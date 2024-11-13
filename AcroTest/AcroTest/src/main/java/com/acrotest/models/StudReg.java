package com.acrotest.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudReg 
{
	@NotNull(message = "Name Can't be Null")
	@NotEmpty(message = "Empty Name Not Allowed")
	private String name;
	
	@NotNull(message = "Branch Can't be Null")
	@NotEmpty(message = "Empty Branch Not Allowed")
	private String branch;
	
	@NotNull(message = "EnRoll Can't be Null")
	@NotEmpty(message = "Empty Enroll Not Allowed")
	private String enroll;
	
	@NotNull(message = "Sem Can't be Null")
	private int semester;
	
	@NotNull(message = "Email Can't be Null")
	@NotEmpty(message = "Empty Email Not Allowed")
	private String email;
	
	@NotNull(message = "Password Can't be Null")
	@NotEmpty(message = "Empty Password Not Allowed")
	private String password;
}
