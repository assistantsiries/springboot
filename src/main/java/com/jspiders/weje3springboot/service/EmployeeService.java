package com.jspiders.weje3springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.weje3springboot.pojo.EmployeePojo;
import com.jspiders.weje3springboot.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	public EmployeePojo addEmployee(EmployeePojo employee) {
		EmployeePojo pojo = repository.save(employee);
		return pojo;
	}

	public List<EmployeePojo> addAllEmployee(List<EmployeePojo> employees) {
		List<EmployeePojo> pojo = repository.saveAll(employees);
		return pojo;
	}

	public EmployeePojo getEmployee(int id) {
		EmployeePojo pojo = repository.findById(id).orElse(null);
		return pojo;

	}

	public EmployeePojo getEmployeeName(String name) {
		EmployeePojo pojo = repository.findByName(name);
		return pojo;
	}

	public String deleteEmployee(int id) {
		repository.deleteById(id);
		return "Employee data remove successfully..!!";
	}

	public EmployeePojo updateEmployee(EmployeePojo employee) {
		EmployeePojo existingEmployee = repository.findById(employee.getId()).orElse(null);
		existingEmployee.setName(employee.getName());
		existingEmployee.setEmail(employee.getEmail());
		repository.save(existingEmployee);
		return existingEmployee;
	}
}
