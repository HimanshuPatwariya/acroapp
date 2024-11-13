package com.acrotest.entities;

import com.acrotest.models.StudReg;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")
public class Student extends User
{
	

	@Column(name = "enroll_number",nullable = false,unique = true)
	private String enrollNumber;
	
	@Column(name = "branch",nullable = false)
	private String branch;
	
	@Column(name = "semester",nullable = false)
	private Integer semester;
	
	public Student(StudReg regObj) 
	{
		this.enrollNumber = regObj.getEnroll();
		this.branch = regObj.getBranch();
		this.semester = regObj.getSemester();
		this.setName(regObj.getName());
		this.setEmail(regObj.getEmail());
		this.setPassword(regObj.getPassword());
		this.setRole("ROLE_STUDENT");
	}
}
