package com.empdata.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.empdata.EmployeeEntity.EmployeeDetails;
import com.empdata.Service.EmployeeService;

@RestController
public class EmployeeController {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(EmployeeDetails.class);

	
	@Autowired
	private EmployeeService empervice;

	@GetMapping("/employee")
	public ResponseEntity<List<EmployeeDetails>> getEmp() {


		List<EmployeeDetails> l=empervice.GetAllEmployee();
		if(l.size()<=0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		LOGGER.info("employee get");
		return ResponseEntity.status(HttpStatus.CREATED).body(l);
	}
	
	@GetMapping("/employee/{id}")
	public EmployeeDetails findById(@PathVariable("id") int id)
	{
		
		return empervice.singleEmployee(id);
	}
	
	@PostMapping("/employee")
	public ResponseEntity<EmployeeDetails> addEmp(@RequestBody EmployeeDetails bo)
	{
		EmployeeDetails b=	null;
	    try
	    {
	    	b=this.empervice.Addemployee(bo);
		    System.out.println(bo);
		    LOGGER.info("employee add", bo);
		   return ResponseEntity.of(Optional.of(b));
	    }
	    	catch (Exception e) {
				// TODO: handle exception
	    		e.printStackTrace();
	    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}	
		
	}
	
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<Void> deleteEmp(@PathVariable("id") int id)
	{
		try
		{
			this.empervice.deleteEmployee(id);
			LOGGER.info("employee deleyte", id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping("/employee/{id}")
	public ResponseEntity<EmployeeDetails>  updateEmp(@RequestBody EmployeeDetails emp, @PathVariable("id") int id)
	{
		try
		{
			this.empervice.updateEmployee(emp, id);
			LOGGER.info("employee update", emp);
			return ResponseEntity.status(HttpStatus.OK).body(emp);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
		
	}

}
