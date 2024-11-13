package com.acrotest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acrotest.entities.Faculty;
import com.acrotest.entities.Student;
import com.acrotest.models.FacReg;
import com.acrotest.models.StudReg;
import com.acrotest.repositories.FacRepo;
import com.acrotest.repositories.StudRepo;
import com.acrotest.utils.ApiResponse;

@Service
public class FacultyService 
{
	@Autowired
	private FacRepo facRepo;
	
	public ApiResponse register(FacReg regObj) 
	{
		try 
		{
			Faculty ob = new Faculty(regObj);
			facRepo.save(ob);
			return new ApiResponse(true, "Faculty Registeration Done !", null);
		}catch(Exception ex) {
			return new ApiResponse(false, 
					"Faculty Registeration Failed !", ex.getMessage());
		}
	}
}
