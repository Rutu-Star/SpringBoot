package com.springboot.DepartmentSystem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
	
	@Autowired
	DepartmentRepository depRepository;
	
	//add the department
	Department addDepartment(Department department)
	{
		return depRepository.save(department);
	}
	
	//get all department 
	List<Department> getAllDepartment()
	{
		return depRepository.findAll();
	}
	
	//get department by id
	Department getById(long id)
	{
		return depRepository.findById(id).orElse(null);
	}
	

}
