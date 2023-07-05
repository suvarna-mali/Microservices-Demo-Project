package com.deptdata.Repository;

import org.springframework.data.repository.CrudRepository;

import com.deptdata.Entity.DepartmentEntity;

public interface DepartmentRepository extends CrudRepository<DepartmentEntity, Integer>{

	public DepartmentEntity findById(int id);
	
}
