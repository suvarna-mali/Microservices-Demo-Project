package com.deptdata.Client;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.HttpExchange;

import com.deptdata.Entity.DepartmentEntity;
import com.deptdata.Entity.EmployeeDetails;


@HttpExchange
public interface EmployeeClient {

	/*
	 * @GetMapping("/employee/department/{id}") public DepartmentEntity
	 * findById(@PathVariable("id") int id);
	 */

	@GetMapping("/employee/{id}")
	public EmployeeDetails findById(@PathVariable("id") int id);
	
}
