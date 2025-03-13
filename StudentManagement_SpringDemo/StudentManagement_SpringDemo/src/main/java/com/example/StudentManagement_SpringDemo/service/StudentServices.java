package com.example.StudentManagement_SpringDemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.StudentManagement_SpringDemo.model.Student;
import com.example.StudentManagement_SpringDemo.repository.StudentRepository;

@Service
public class StudentServices{

	@Autowired
	StudentRepository repository;
	
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		repository.save(student);
		
	}

	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		
		return repository.findAll();
	}

	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		Optional<Student> student=repository.findById(id);
		student.ifPresent(repository::delete);
		
	}

}
