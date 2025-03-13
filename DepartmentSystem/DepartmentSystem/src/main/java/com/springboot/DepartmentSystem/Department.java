package com.springboot.DepartmentSystem;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long department_id;
	@Column(name="department_name",nullable=false)
	private String department_name;
	@Column(name="location",nullable=false)
	private String location;
	public Department(String department_name, String location) {
		super();
		this.department_name = department_name;
		this.location = location;
	}
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(long department_id) {
		this.department_id = department_id;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Department [department_id=" + department_id + ", department_name=" + department_name + ", location="
				+ location + "]";
	}
	
	

}
