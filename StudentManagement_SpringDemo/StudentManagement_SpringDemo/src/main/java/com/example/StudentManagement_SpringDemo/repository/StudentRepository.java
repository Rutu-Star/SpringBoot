package com.example.StudentManagement_SpringDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.StudentManagement_SpringDemo.model.Student;

public interface StudentRepository extends JpaRepository<Student,Integer>{

}
