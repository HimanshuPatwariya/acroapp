package com.acrotest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acrotest.entities.Student;
import com.acrotest.entities.User;
@Repository
public interface StudRepo extends JpaRepository<Student, Integer>{

}
