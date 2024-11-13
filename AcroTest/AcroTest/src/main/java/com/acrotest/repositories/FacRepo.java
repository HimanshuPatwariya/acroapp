package com.acrotest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acrotest.entities.Faculty;
import com.acrotest.entities.User;
@Repository
public interface FacRepo extends JpaRepository<Faculty, Integer>{

}
