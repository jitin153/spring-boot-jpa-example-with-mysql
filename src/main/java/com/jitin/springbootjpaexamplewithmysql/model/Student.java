package com.jitin.springbootjpaexamplewithmysql.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "student_info")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer rollNumber;
	private String name;
	private String email;
	@Enumerated(EnumType.STRING)
	private Course course;
}
