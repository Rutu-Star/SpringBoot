package com.springsecurity.DemoSpringSecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class SecurityController {
	//simple get method
		@GetMapping("/")
		public String hello(HttpServletRequest request)
		{
			System.out.println(request.getSession().getId());
			return "Hello Rutuja . Welcome!   "+request.getSession().getId();
		}

}



