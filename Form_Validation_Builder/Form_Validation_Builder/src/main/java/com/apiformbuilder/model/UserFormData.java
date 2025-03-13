package com.apiformbuilder.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class UserFormData {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	
	@NotBlank(message="Username is required")
	@Size(min=3, message="Username should be at least 3 characters long ")
	private String username;
	
	@NotNull(message="Age is required")
	@Min(value = 18, message="Age must be 18 or older")
	private int age;
	
	
	private String gender;
	
	@Override
	public String toString() {
		return "UserFormData [id=" + id + ", username=" + username + ", age=" + age + ", gender=" + gender + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}


}
