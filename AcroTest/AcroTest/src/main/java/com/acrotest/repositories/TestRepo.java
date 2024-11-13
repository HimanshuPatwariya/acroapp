package com.acrotest.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acrotest.entities.Test;
import com.acrotest.entities.User;

@Repository
public interface TestRepo extends JpaRepository<Test, Integer>
{
	List<Test> findByStatus(boolean status);
	List<Test> findByUser(User user);
}
