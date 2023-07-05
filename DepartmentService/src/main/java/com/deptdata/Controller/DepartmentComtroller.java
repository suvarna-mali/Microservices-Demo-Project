package com.deptdata.Controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.deptdata.Client.EmployeeClient;
import com.deptdata.Entity.DepartmentEntity;
import com.deptdata.Service.DepartmentService;

@RestController
public class DepartmentComtroller {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(DepartmentComtroller.class);

	@Autowired
	private DepartmentService deptservice;
	
	@Autowired
	private EmployeeClient empclient;

	@GetMapping("/department")
	public ResponseEntity<List<DepartmentEntity>> getDept() {


		List<DepartmentEntity> l=deptservice.GetAllDept();
		if(l.size()<=0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		  LOGGER.info("department get");
		return ResponseEntity.status(HttpStatus.CREATED).body(l);
	}
	@GetMapping("/department/{id}")
	public DepartmentEntity findById(@PathVariable("id") int id)
	{
		
		return deptservice.singleDepartment(id);
	}
	
	@PostMapping("/department")
	public ResponseEntity<DepartmentEntity> addDept(@RequestBody DepartmentEntity de)
	{
		DepartmentEntity d=	null;
	    try
	    {
	    	d=this.deptservice.AddDepartment(de);
		    System.out.println(de);
		    LOGGER.info("department add", de);
		   return ResponseEntity.of(Optional.of(d));
	    }
	    	catch (Exception e) {
				// TODO: handle exception
	    		e.printStackTrace();
	    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}	
		
	}
	
	@DeleteMapping("/department/{id}")
	public ResponseEntity<Void> deleteDepartment(@PathVariable("id") int id)
	{
		try
		{
			this.deptservice.deleteDepartment(id);
			  LOGGER.info("department delete", id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping("/department/{id}")
	public ResponseEntity<DepartmentEntity>  updateDept(@RequestBody DepartmentEntity d, @PathVariable("id") int id)
	{
		try
		{
			this.deptservice.updateDepartment(d, id);
			  LOGGER.info("department update", d);
			return ResponseEntity.status(HttpStatus.OK).body(d);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
		
	}
	
	@GetMapping("/with-employee")
	public List<DepartmentEntity> getDeptWithEmp() {


		List<DepartmentEntity> l=deptservice.GetAllDept();
		return l;
		
	}
	
}
