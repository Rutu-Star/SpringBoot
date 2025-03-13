package com.apiformbuilder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.apiformbuilder.model.UserFormData;
import com.apiformbuilder.service.UserFormService;
import com.apiformbuilder.model.UserRegistrationForm;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.util.Map;
import java.util.HashMap;


@RestController
@RequestMapping("/api")

public class UserFormController {
	
	
	
	@Autowired
	UserFormService service;

	
	//map for form types with their class 
	private final Map<String,Class<?>> formTypeMap=new HashMap<>();
	
	//put the values of each class with their form type
	@Autowired
	public void initFormTypeMap()
	{
		formTypeMap.put("userdata",UserFormData.class);
		formTypeMap.put("registration", UserRegistrationForm.class);
	}
	
	
	//take use dyanamic form data and pass to specfic serivce method 
	
		@PostMapping("/submit-form")
		public ResponseEntity<?> GenericformSubmission(@RequestBody  Map<String, Object> formdata)
		{ 
			ObjectMapper mapper = new ObjectMapper();

			
			String formType=(String) formdata.get("formType");
			Class<?> formDataClass=formTypeMap.get(formType);
			
			if(formDataClass==null)
			{
				return new ResponseEntity<>("Wrong Form Type ",HttpStatus.BAD_REQUEST);
				
			}
			
			try
			{
	            Object formData = mapper.convertValue(formdata.get("formData"), formDataClass);
	            return service.formSubmission(formData);


			}catch(Exception e)
			{
				return new ResponseEntity<>("Error processing form data "+e,HttpStatus.EXPECTATION_FAILED);
			}
			
			
			
			
		}
	
	
	
	//get methods
	@GetMapping("hello")
	public String Hello()
	{
		return "Hello Rutuja";
	}

}
