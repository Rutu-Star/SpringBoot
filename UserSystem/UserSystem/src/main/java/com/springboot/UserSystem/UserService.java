package com.springboot.UserSystem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
	
	@Autowired 
	UserRepository userRepo;
	
	@Autowired 
	RestTemplate restTemplate;
	
	//Add the User
	User addUser(User user)
	{
		return userRepo.save(user);
	}
	
	//getAllUSer
	List<User> getAllUser()
	{
		return userRepo.findAll();
	}
	
	//get user with department using userid
	DepartmentUserDTO userWithDepartment(int userId)
	{
		User user=userRepo.findById(userId).orElse(null);
		if(user==null)
		{
			return null;
		}
		String departmentServiceUrl="http://localhost:8082/departments/"+(long)user.getDepartmentId();
		
		Department department=restTemplate.getForObject(departmentServiceUrl, Department.class);
		
		DepartmentUserDTO response=new DepartmentUserDTO();
		
		response.setUserId(userId);
		response.setUserName(user.getName());
		response.setUserEmail(user.getEmail());
		response.setDptName(department.getName());
		response.setLocation(department.getLocation());
		
	
		return response;
		
	}
	
	static class  Department
	{
		@Override
		public String toString() {
			return "Department [name=" + name + ", location=" + location + "]";
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		private String name;
		private String location;
		
	}

}
