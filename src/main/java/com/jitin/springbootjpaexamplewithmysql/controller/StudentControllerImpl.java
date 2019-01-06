package com.jitin.springbootjpaexamplewithmysql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jitin.springbootjpaexamplewithmysql.model.Response;
import com.jitin.springbootjpaexamplewithmysql.model.Student;
import com.jitin.springbootjpaexamplewithmysql.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentControllerImpl implements StudentController {
	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Response addStudent(@RequestBody Student student) {
		return studentService.addStudent(student);
	}
	
	@RequestMapping(value = "/saveall", method = RequestMethod.POST)
	public Response addStudents(@RequestBody List<Student> students) {
		return studentService.addStudents(students);
	}
	
	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	public Response getAllStudent() {
		return studentService.getAllStudent();
	}

	@RequestMapping(value = "/get/{rollNumber}", method = RequestMethod.GET)
	public Response getStudent(@PathVariable("rollNumber") Integer rollNumber) {
		return studentService.getStudent(rollNumber);
	}

	@RequestMapping(value = "/delete/{rollNumber}", method = RequestMethod.DELETE)
	public Response deleteStudent(@PathVariable("rollNumber") Integer rollNumber) {
		return studentService.deleteStudent(rollNumber);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Response updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}

	@RequestMapping(value = "/updatecourse", method = RequestMethod.PATCH)
	public Response updateCourse(@RequestBody Student student) {
		return studentService.updateCourse(student);
	}

}
