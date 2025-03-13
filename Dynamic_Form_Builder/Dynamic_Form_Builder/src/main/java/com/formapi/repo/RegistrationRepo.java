package com.formapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formapi.model.UserRegistrationForm;

@Repository
public interface RegistrationRepo extends JpaRepository<UserRegistrationForm,Long>{

}
