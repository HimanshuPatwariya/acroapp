package com.acrotest.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse 
{
	private boolean status;
	private String msg;
	private String error;
	private Object data;
	
	public ApiResponse(boolean status, String msg, Object data) {
		super();
		this.status = status;
		this.msg = msg;
		this.data = data;
	}
	public ApiResponse(boolean status, String msg, String error) {
		super();
		this.status = status;
		this.msg = msg;
		this.error = error;
	}
}
