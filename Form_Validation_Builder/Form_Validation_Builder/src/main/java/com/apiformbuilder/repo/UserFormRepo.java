package com.apiformbuilder.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apiformbuilder.model.UserFormData;

@Repository
public interface UserFormRepo extends JpaRepository<UserFormData,Long> {

}
