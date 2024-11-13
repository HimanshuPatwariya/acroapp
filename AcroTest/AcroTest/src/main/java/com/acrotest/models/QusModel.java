package com.acrotest.models;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QusModel 
{
	@NotNull(message = "Question Can't be Null")
	@NotEmpty(message = "Question Can't be Empty")
	private String question;
	
	@NotNull(message = "Ans1 Can't be Null")
	@NotEmpty(message = "Ans1 Can't be Empty")
	private String ans1;
	
	@NotNull(message = "Ans2 Can't be Null")
	@NotEmpty(message = "Ans2 Can't be Empty")
	private String ans2;
	
	@NotNull(message = "Ans3 Can't be Null")
	@NotEmpty(message = "Ans3 Can't be Empty")
	private String ans3;
	
	@NotNull(message = "Ans4 Can't be Null")
	@NotEmpty(message = "Ans4 Can't be Empty")
	private String ans4;
	
	@NotNull(message = "Right Answer Can't be Null")
	private Integer rightAns;
}
