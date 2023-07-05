package com.deptdata.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.deptdata.Entity.DepartmentEntity;
import com.deptdata.Repository.DepartmentRepository;

@Component
public class DepartmentService {

	@Autowired
	private DepartmentRepository dr;
	

	public List<DepartmentEntity> GetAllDept()
	{
		List l=(List<DepartmentEntity>) this.dr.findAll();
		 return l;
	}
	
	public DepartmentEntity singleDepartment(int id)
	{
		DepartmentEntity deptdetails=null;
		try {
			deptdetails=this.dr.findById(id);
		}
	  catch (Exception e) {
		// TODO: handle exception
	}
		

		return deptdetails;
	}
	
	
	public DepartmentEntity AddDepartment(DepartmentEntity d)
	{
		DepartmentEntity res=dr.save(d);
		
//		list.add(b);
		return res;
	}
	
	public void deleteDepartment(int did)
	{
		dr.deleteById(did);
		

	}
	
	public void updateDepartment(DepartmentEntity d, int id)
	{
		d.setDeptid(id);
		dr.save(d);
		
	}
	
}
