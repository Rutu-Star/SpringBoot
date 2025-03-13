package com.example.StudentManagement_SpringDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.StudentManagement_SpringDemo.model.Student;
import com.example.StudentManagement_SpringDemo.service.StudentServices;

@RestController
@RequestMapping("/students")
public class Controller {
	
	@Autowired
	StudentServices services;
	
	//Add student
	@PostMapping
	public String addStudent(@RequestBody Student student)
	{
		services.addStudent(student);
		return "Student added successfully ! ";
	}
	
	//get all student
	@GetMapping
	public List<Student> getAllStudent()
	{
		return services.getAllStudent();
		
	}
	
	//delete student by id
	@DeleteMapping("/{id}")
	public String deleteStudent(@PathVariable int id)
	{
		services.deleteStudent(id);
		return "Student deleted successfully !";
	}
	

}
