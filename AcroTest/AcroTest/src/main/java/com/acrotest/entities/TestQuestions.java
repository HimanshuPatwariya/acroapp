package com.acrotest.entities;

import java.time.LocalDate;

import com.acrotest.models.QusModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "questions")
public class TestQuestions 
{


	@Id
	@Column(name = "qusid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer qusId;
	
	@Column(name = "question",nullable = false)
	private String question;
	
	@Column(name = "ans1",nullable = false)
	private String ans1;
	@Column(name = "ans2",nullable = false)
	private String ans2;
	@Column(name = "ans3",nullable = false)
	private String ans3;
	@Column(name = "ans4",nullable = false)
	private String ans4;
	
	@Column(name = "right_ans",nullable = false)
	private Integer rightAns;
	
	@ManyToOne
	@JoinColumn(name = "test")
	private Test test;	
	
	public TestQuestions(QusModel model) {
		this.question = model.getQuestion();
		this.ans1 = model.getAns1();
		this.ans2 = model.getAns2();
		this.ans3 = model.getAns3();
		this.ans4 = model.getAns4();
		this.rightAns = model.getRightAns();
	}
}
