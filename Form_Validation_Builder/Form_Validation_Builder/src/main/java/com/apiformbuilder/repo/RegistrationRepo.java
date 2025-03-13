package com.apiformbuilder.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apiformbuilder.model.UserRegistrationForm;


public interface RegistrationRepo extends JpaRepository<UserRegistrationForm,Long> {

}
