package com.deptdata.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DepartmentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int deptid;
	private String deptname;
	public DepartmentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DepartmentEntity(int deptid, String deptname) {
		super();
		this.deptid = deptid;
		this.deptname = deptname;
	}
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	@Override
	public String toString() {
		return "DepartmentEntity [deptid=" + deptid + ", deptname=" + deptname + "]";
	}
	
}
