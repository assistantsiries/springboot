package com.jspiders.weje3springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.weje3springboot.pojo.EmployeePojo;
import com.jspiders.weje3springboot.response.EmployeeResponse;
import com.jspiders.weje3springboot.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@PostMapping("/add")
	public ResponseEntity<EmployeeResponse> addEmployee(@RequestBody EmployeePojo employee) {
		EmployeePojo pojo = service.addEmployee(employee);
		if (pojo != null) {
			// success response
			return new ResponseEntity<EmployeeResponse>(
					new EmployeeResponse("OK", "Employee data added..!!", pojo, null), HttpStatus.ACCEPTED);
		}
		// failure response
		return new ResponseEntity<EmployeeResponse>(new EmployeeResponse
				("FAIL", "Employee data not added", null, null),
				HttpStatus.BAD_REQUEST);

	}

	@PostMapping("/addAll")
	public ResponseEntity<EmployeeResponse> addAllEmployee(@RequestBody List<EmployeePojo> employess) {
		List<EmployeePojo> pojo = service.addAllEmployee(employess);
		if (pojo != null) {
			// success response

			return new ResponseEntity<EmployeeResponse>(
					new EmployeeResponse("OK", "All Employee data added successfully..!!", null, pojo),
					HttpStatus.ACCEPTED);
		}
		// failure response

		return new ResponseEntity<EmployeeResponse>(
				new EmployeeResponse("Fail", "All Employee data not added..!!", null, null), HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<EmployeeResponse> findEmployee(@PathVariable int id) {
		EmployeePojo pojo = service.getEmployee(id);
		if (pojo != null) {
			// success response
			return new ResponseEntity<EmployeeResponse>(
					new EmployeeResponse("OK", "Employee data found..!!", pojo, null), HttpStatus.ACCEPTED);
		}
		// failure response
		return new ResponseEntity<EmployeeResponse>(
				new EmployeeResponse("Fail", "Employee data not found..!!", null, null)
				, HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/employee/{name}")
	public ResponseEntity<EmployeeResponse> findEmployeeName(@PathVariable String name){
		EmployeePojo pojo=service.getEmployeeName(name);
		if(pojo!=null) {
			//success response
			return new ResponseEntity<EmployeeResponse>(
					new EmployeeResponse("OK", "Employee data found..!!", pojo, null)
					, HttpStatus.ACCEPTED);
		}
		//failure response
		return new ResponseEntity<EmployeeResponse>(
				new EmployeeResponse("Fail", "Employee  data not found..!!", null, null)
				, HttpStatus.BAD_REQUEST);
	
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable int id) {
		return service.deleteEmployee(id);
	}
	
	@PutMapping("/update")
	public ResponseEntity<EmployeeResponse> updateEmployee(@RequestBody EmployeePojo employee){
		EmployeePojo pojo=service.updateEmployee(employee);
		
		if(pojo!=null) {
			//success response
			return new ResponseEntity<EmployeeResponse>(
					new EmployeeResponse("OK", "Employee data updated successfully..!!", pojo, null),
					HttpStatus.ACCEPTED);
		}
		//failure response
		return new ResponseEntity<EmployeeResponse>(
				new EmployeeResponse("Fail", "Employee data not updated..!!",null, null),
				HttpStatus.BAD_REQUEST);
	}
		
}
