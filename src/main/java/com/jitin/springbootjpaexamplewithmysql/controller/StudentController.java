package com.jitin.springbootjpaexamplewithmysql.controller;

import java.util.List;

import com.jitin.springbootjpaexamplewithmysql.model.Response;
import com.jitin.springbootjpaexamplewithmysql.model.Student;

public interface StudentController {
	public Response addStudent(Student student);

	public Response addStudents(List<Student> students);

	public Response getAllStudent();

	public Response getStudent(Integer rollNumber);

	public Response deleteStudent(Integer rollNumber);

	public Response updateStudent(Student student);

	public Response updateCourse(Student student);
}
