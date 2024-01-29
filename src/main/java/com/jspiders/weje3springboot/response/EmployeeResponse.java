package com.jspiders.weje3springboot.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jspiders.weje3springboot.pojo.EmployeePojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeResponse {
	
	private String status;
	private String msg;
	private EmployeePojo data;
	private List<EmployeePojo> list;
	

}
