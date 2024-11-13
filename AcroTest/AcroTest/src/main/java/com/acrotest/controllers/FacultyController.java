package com.acrotest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acrotest.entities.Test;
import com.acrotest.entities.TestQuestions;
import com.acrotest.entities.User;
import com.acrotest.models.QusModel;
import com.acrotest.models.TestModel;
import com.acrotest.services.TestService;
import com.acrotest.utils.ApiResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth/faculty")
public class FacultyController extends BaseController
{
	@Autowired
	private TestService testService;

	
	@PostMapping("/savetest")
	public ApiResponse saveTest(@Valid @RequestBody TestModel model) 
	{
		Object principal = SecurityContextHolder
								.getContext()
								.getAuthentication()
								.getPrincipal();
		User loginUser = ((User) principal);
		return testService.saveTest(model,loginUser);
	}
	
	@PostMapping("/savequs/{testid}")
	public ApiResponse saveQus(@Valid @RequestBody QusModel model,
			@PathVariable(value = "testid") Integer testid) 
	{
		return testService.saveQuestion(model,testid);
	}
	
	@GetMapping("/listqus/{testid}")
	public ApiResponse listQus(@PathVariable(value = "testid") Integer testid) 
	{
		List<TestQuestions> list =  testService.listQuestions(testid);
		ApiResponse res = new ApiResponse(true, "Questions Records", list);
		return res;
	}
	
	@GetMapping("/mytestlist")
	public ApiResponse testList() 
	{
		Object principal = SecurityContextHolder
				.getContext()
				.getAuthentication()
				.getPrincipal();
		User loginUser = ((User) principal);
		
		List<Test> flist = testService.listByFaculty(loginUser);
		ApiResponse res = new ApiResponse(true, "Test Records", flist);
		return res;
	}
	
}
