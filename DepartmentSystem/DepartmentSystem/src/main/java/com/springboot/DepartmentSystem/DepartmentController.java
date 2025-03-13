package com.springboot.DepartmentSystem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
	
	@Autowired
	DepartmentService dptSerive;
	
	//add department 
	@PostMapping
	Department addDepartment(@RequestBody Department department)
	{
		return dptSerive.addDepartment(department);
	}
	
	//Get all department 
	@GetMapping
	List<Department> getAllDepartment()
	{
		return dptSerive.getAllDepartment();
	}
	
	//get department by id
	@GetMapping("/{Id}")
	Department getDepartmentById(@PathVariable long Id)
	{
		return dptSerive.getById(Id);
	}

}
