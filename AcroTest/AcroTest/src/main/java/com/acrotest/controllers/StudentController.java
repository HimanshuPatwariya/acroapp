package com.acrotest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acrotest.entities.Test;
import com.acrotest.services.TestService;
import com.acrotest.utils.ApiResponse;

@RestController
@RequestMapping("/auth/student")
public class StudentController extends BaseController
{
	@Autowired
	private TestService testService;
	
	@GetMapping("/testlist")
	public ApiResponse testList() 
	{
		List<Test> flist = testService.listAll();
		ApiResponse res = new ApiResponse(true, "Test Records", flist);
		return res;
	}
}
