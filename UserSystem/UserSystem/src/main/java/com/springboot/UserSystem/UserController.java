package com.springboot.UserSystem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	//add the user
	@PostMapping
	User addUser(@RequestBody User user)
	{
		return userService.addUser(user);
	}
	//get all user list
	@GetMapping
	List<User> getAllUSer()
	{
		return userService.getAllUser();
	}
	//get user along with their department details 
	
	@GetMapping("/{userid}/with-department")
	DepartmentUserDTO userWithDepartment(@PathVariable int userid)
	{
		return userService.userWithDepartment(userid);
	}
	

}
