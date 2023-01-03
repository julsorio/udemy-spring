package com.udemy.springboot.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udemy.springboot.crud.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
