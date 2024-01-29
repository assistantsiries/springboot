package com.jspiders.weje3springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspiders.weje3springboot.pojo.EmployeePojo;

public interface EmployeeRepository extends JpaRepository<EmployeePojo, Integer> {

	EmployeePojo findByName(String name);
	
	

}
