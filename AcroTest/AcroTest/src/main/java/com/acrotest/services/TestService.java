package com.acrotest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acrotest.entities.Faculty;
import com.acrotest.entities.Test;
import com.acrotest.entities.TestQuestions;
import com.acrotest.entities.User;
import com.acrotest.models.QusModel;
import com.acrotest.models.TestModel;
import com.acrotest.repositories.QusRepo;
import com.acrotest.repositories.TestRepo;
import com.acrotest.utils.ApiResponse;

import jakarta.validation.Valid;

@Service
public class TestService 
{
	@Autowired
	private TestRepo testRepo;
	@Autowired
	private QusRepo qusRepo;
	
	public ApiResponse saveTest(TestModel model,User user) 
	{
		try 
		{
			Test ob = new Test(model);
			ob.setUser(user);
			testRepo.save(ob);
			
			return new ApiResponse(true, "Test Save Successfully !", null);
		}catch(Exception ex) {
			return new ApiResponse(false, 
					"Test Save Failed !", ex.getMessage());
		}
	}

	public ApiResponse saveQuestion(@Valid QusModel model, Integer testid) 
	{
		TestQuestions tq = null;
		try 
		{
			Optional<Test> op = testRepo.findById(testid);
			if(op.isPresent()) 
			{
				tq = new TestQuestions(model);
				tq.setTest(op.get());
				tq = qusRepo.save(tq);
			}else
				return new ApiResponse(false, 
						"Test Qus Save Failed !", "Wrong Test Id !");
			return new ApiResponse(true, "Test Qus Save Successfully !", tq);
		}catch(Exception ex) {
			return new ApiResponse(false, 
					"Test Qus Save Failed !", ex.getMessage());
		}
	}

	public List<Test> listAll() 
	{
		return testRepo.findByStatus(true);
	}

	public List<Test> listByFaculty(User loginUser) 
	{
		return testRepo.findByUser(loginUser);
	}

	public List<TestQuestions> listQuestions(Integer testid) 
	{
		Optional<Test> op = testRepo.findById(testid);
		if(op.isPresent())
		{
			return qusRepo.findByTest(op.get());
		}else
			return null;
	}
}
