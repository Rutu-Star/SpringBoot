package com.apiformbuilder.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class UserRegistrationForm {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message="first name is required")
	@Size(min=3,message="first name must be greater than 3 characters ")
	private String first_name;
	
	private String last_name;
	
	@NotNull(message="Age is required ")
	@Min(value=18,message="Age must be 18 or older")
	private int age;
	
	@NotEmpty(message="Email is required ")
	@Email(message="Invalid email format ")
	private String email;
	
    @NotEmpty(message = "Username is required")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Username can only contain letters")
    @Size(min=3,message="Username must be greater than 3 characters ")
	private String username;
	
	 @NotEmpty(message = "Password is required")
	 @Size(min = 6, max =15, message = "Password must be between 6 and 15 characters")
	 @Pattern(regexp = "(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*]).+",
	    message = "Password must contain at least one digit,"
	    		+ " one lowercase letter,"
	    		+ " one uppercase letter, "
	    		+ "and one special character")
	private String password;
	 

	@Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must contain exactly 10 digits")
	private String contact_number;
	
	
	
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getContact_number() {
		return contact_number;
	}


	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}


	@Override
	public String toString() {
		return "UserRegistrationForm [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", age="
				+ age + ", email=" + email + ", username=" + username + ", password=" + password + ", contact_number="
				+ contact_number + "]";
	}
	



}
