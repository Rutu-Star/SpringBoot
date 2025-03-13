package com.apiformbuilder.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import com.apiformbuilder.model.UserFormData;
import com.apiformbuilder.repo.UserFormRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.apiformbuilder.model.UserRegistrationForm;
import com.apiformbuilder.repo.RegistrationRepo;
import java.util.HashMap;
import java.util.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import java.util.Set;



@Service
@Validated
public class UserFormService {
	
	
	
	@Autowired
	UserFormRepo userdatarepo;
	
	@Autowired 
	RegistrationRepo registrionRepo;
	

    @Autowired
    private Validator validator;
    
    
    //create map with their class and jparepository 
    private final Map<Class<?>,JpaRepository<?,Long>> repositoryMap=new HashMap<>();
    
    @Autowired
    public void initRepositoryMap()
    {
    	repositoryMap.put(UserFormData.class, userdatarepo);
    	repositoryMap.put(UserRegistrationForm.class, registrionRepo);
    }
    
    //Generic method for validating different forms and save to their specific Repository
    public <T> ResponseEntity<?> formSubmission(T formData)
    {
        System.out.println("Received data: " + formData);
        
        //perform manual validation
        Set<ConstraintViolation<T>> violations=validator.validate(formData);
        if(!violations.isEmpty())
        {
        	StringBuilder errorMessage=new StringBuilder();
        	violations.forEach(error->errorMessage.append(error.getMessage()).append("\n"));
        	
        	return new ResponseEntity<>("Bad Request\n"+errorMessage.toString(),HttpStatus.BAD_REQUEST);
        }
        
        try
        {
        	//get specific repository from map 
        	JpaRepository<T,Long> repository=(JpaRepository<T,Long>) repositoryMap.get(formData.getClass());
        	
        	if(repository==null)
        	{
        		return new ResponseEntity<>("Form type is not suported (Wrong form type)",HttpStatus.BAD_REQUEST);
        	}
        	
        	repository.save(formData);
        	return new ResponseEntity<>("Form submitted successfully",HttpStatus.OK);
        	
        }catch(Exception e)
        {
        	return new ResponseEntity<>("Internal Error form not submited to database",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
	
	/*@Autowired
	UserFormRepo repo;
	
	//validate and save the user form data to database
	@Async
	public CompletableFuture<Void> formSubmission(UserFormData userformdata)
	{
	    
		repo.save(userformdata);
		
	    return CompletableFuture.completedFuture(null);
		
	}
	*/
	

}
