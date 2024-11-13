package com.acrotest.entities;

import com.acrotest.models.FacReg;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "faculties")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Faculty extends User
{

	public Faculty(FacReg regObj) {
		this.facid = regObj.getFacid();
		this.phone = regObj.getPhone();
		this.setName(regObj.getName());
		this.setEmail(regObj.getEmail());
		this.setPassword(regObj.getPassword());
		this.setRole("ROLE_FACULTY");
	}

	@Column(name = "facid",nullable = false,unique = true)
	private Integer facid;
	
	@Column(name = "phone",nullable = false)
	private String phone;
}
