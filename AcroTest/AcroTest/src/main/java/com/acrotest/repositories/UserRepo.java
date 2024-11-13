package com.acrotest.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acrotest.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>
{
	Optional<User> findByEmailAndPassword(String email,String password);
	Optional<User> findByEmail(String email);
	
	List<User> findByRole(String role);
}
