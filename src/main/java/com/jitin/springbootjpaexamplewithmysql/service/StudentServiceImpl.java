package com.jitin.springbootjpaexamplewithmysql.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jitin.springbootjpaexamplewithmysql.model.Response;
import com.jitin.springbootjpaexamplewithmysql.model.Student;
import com.jitin.springbootjpaexamplewithmysql.repository.StudentRepository;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository studentRepository;

	public Response addStudent(Student student) {

		return new Response(studentRepository.save(student), Boolean.FALSE);
	}

	public Response addStudents(List<Student> students) {

		return new Response(studentRepository.saveAll(students), Boolean.FALSE);
	}
	
	public Response getAllStudent() {
		return new Response(studentRepository.findAll(), Boolean.FALSE);
	}

	public Response getStudent(Integer rollNumber) {
		Optional<Student> optionalStudent = studentRepository.findById(rollNumber);
		Student student = new Student();
		if (optionalStudent.isPresent()) {
			return new Response(optionalStudent.get(), Boolean.FALSE);
		} else {
			return new Response("Student not found for this roll number : " + rollNumber, Boolean.TRUE);
		}
	}

	public Response deleteStudent(Integer rollNumber) {
		Response response = this.getStudent(rollNumber);
		if (response.getIsError()) {
			return response;
		} else {
			studentRepository.deleteById(rollNumber);
			return new Response("Successfully deleted!", Boolean.FALSE);
		}
	}

	public Response updateStudent(Student student) {
		Response response = this.getStudent(student.getRollNumber());
		if (response.getIsError()) {
			return response;
		} else {
			return new Response(studentRepository.save(student), Boolean.FALSE);
		}
	}

	public Response updateCourse(Student student) {
		Response response = this.getStudent(student.getRollNumber());
		if (response.getIsError()) {
			return response;
		} else {
			Student existingStudent = (Student)response.getResult();
			existingStudent.setCourse(student.getCourse());
			studentRepository.save(existingStudent);
			return new Response(existingStudent, Boolean.FALSE);
		}
	}
}
