package com.empdata.Repository;

import org.springframework.data.repository.CrudRepository;

import com.empdata.EmployeeEntity.EmployeeDetails;

public interface EmployeeRepository extends CrudRepository<EmployeeDetails, Integer> {
	

		public EmployeeDetails findById(int id);
		
	


}
