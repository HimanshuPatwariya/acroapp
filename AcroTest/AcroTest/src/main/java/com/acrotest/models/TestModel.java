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
public class TestModel 
{
	@NotNull(message = "Title Can't be Null")
	@NotEmpty(message = "Title Can't be Empty")
	private String title;
	
	@NotNull(message = "Test Date Can't be Null")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
}
