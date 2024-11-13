package com.acrotest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acrotest.entities.Student;
import com.acrotest.models.StudReg;
import com.acrotest.repositories.StudRepo;
import com.acrotest.utils.ApiResponse;

@Service
public class StudentService 
{
	@Autowired
	private StudRepo studRepo;
	
	public ApiResponse register(StudReg regObj) 
	{
		try 
		{
			Student ob = new Student(regObj);
			studRepo.save(ob);
			return new ApiResponse(true, "Student Registeration Done !", null);
		}catch(Exception ex) {
			return new ApiResponse(false, 
					"Student Registeration Failed !", ex.getMessage());
		}
	}

}
