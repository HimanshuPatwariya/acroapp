package com.acrotest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.acrotest.entities.Faculty;
import com.acrotest.entities.User;
import com.acrotest.models.LoginModel;
import com.acrotest.repositories.UserRepo;

import jakarta.validation.Valid;

@Service
public class UserService implements UserDetailsService
{
	@Autowired
	private UserRepo userRepo;
	
	public User checkLogin(@Valid LoginModel model) 
	{
		Optional<User> op = userRepo.findByEmailAndPassword(model.getEmail(), 
				model.getPassword());
		if(op.isPresent())
			return op.get();
		else
			return null;	
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		Optional<User> op = userRepo.findByEmail(username);
		if(op.isPresent())
			return op.get();
		else
			return null;
	}

	public User getById(int userid) 
	{
		Optional<User> op = userRepo.findById(userid);
		if(op.isPresent())
			return op.get();
		else
			return null;
	}

	public List<User> listByRole(String role) 
	{
		return userRepo.findByRole(role);
	}

}
