package com.empdata.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.empdata.EmployeeEntity.EmployeeDetails;
import com.empdata.Repository.EmployeeRepository;

@Component
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository er;
	

	public List<EmployeeDetails> GetAllEmployee()
	{
		List l=(List<EmployeeDetails>) this.er.findAll();
		 return l;
	}
	
	public EmployeeDetails singleEmployee(int id)
	{
		EmployeeDetails empdetails=null;
		try {
			empdetails=this.er.findById(id);
		}
	  catch (Exception e) {
		// TODO: handle exception
	}
		
//		book= list.stream().filter(e->e.getBid()==id).findFirst().get();
		return empdetails;
	}
	
	
	public EmployeeDetails Addemployee(EmployeeDetails e)
	{
		EmployeeDetails res=er.save(e);
		
//		list.add(b);
		return res;
	}
	
	public void deleteEmployee(int eid)
	{
		er.deleteById(eid);
		

	}
	
	public void updateEmployee(EmployeeDetails e, int id)
	{
		e.setEmpid(id);
		er.save(e);
		
	}

}
