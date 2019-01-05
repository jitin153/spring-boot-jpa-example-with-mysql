package com.jitin.springbootjpaexamplewithmysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jitin.springbootjpaexamplewithmysql.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
