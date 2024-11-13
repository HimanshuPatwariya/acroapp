package com.acrotest.entities;

import java.time.LocalDate;

import com.acrotest.models.TestModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "testinfo")
public class Test 
{
	@Id
	@Column(name = "testid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer testId;
	
	@Column(name = "title",nullable = false)
	private String title;
	
	@Column(name = "test_date",nullable = false)
	private LocalDate testDate;
	
	@Column(name = "post_date",nullable = false)
	private LocalDate postDate;
	
	@Column(name = "status",nullable = false)
	private Boolean status;
	
	@ManyToOne
	@JoinColumn(name = "faculty")
	private User user;
	
	public Test(TestModel model) {
		this.title = model.getTitle();
		this.testDate = model.getDate();
		this.postDate = LocalDate.now();
		this.status = true;
	}
}
