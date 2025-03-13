package com.formapi.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formapi.model.UserFormData;

import com.formapi.model.UserRegistrationForm;
import com.formapi.service.UserFormService;


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
	
	/*//take use dyanamic form data and pass to specfic serivce method 
	
	@PostMapping("/submit-form")
	public ResponseEntity<?> GenericformSubmission(@RequestBody  Map<String, Object> formdata)
	{ 
		
		String formType=(String) formdata.get("formType");
		ObjectMapper mapper = new ObjectMapper();
		
		switch(formType)
		{
		case "userdata":
			
			UserFormData userdata = mapper.convertValue(formdata.get("formData"), UserFormData.class);
            return service.formSubmission(userdata);
			
		case "registration":
			
			UserRegistrationForm registrationData = mapper.convertValue(formdata.get("formData"), UserRegistrationForm.class);
            return service.registrationFormSubmission(registrationData);
			
		default :
			return new ResponseEntity<>("Form type is not suported (Wrong form type)",HttpStatus.BAD_REQUEST);
		
		}
		
		
	}
	*/
	@GetMapping("/hello")
	public String hello()
	{
		return "Hello rutu";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
