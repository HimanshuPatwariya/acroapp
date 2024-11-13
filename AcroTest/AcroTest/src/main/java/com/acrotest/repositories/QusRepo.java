package com.acrotest.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acrotest.entities.Test;
import com.acrotest.entities.TestQuestions;

@Repository
public interface QusRepo extends JpaRepository<TestQuestions, Integer>{
	List<TestQuestions> findByTest(Test test);
}
