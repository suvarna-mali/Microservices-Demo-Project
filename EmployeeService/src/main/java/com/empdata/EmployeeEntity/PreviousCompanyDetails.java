package com.empdata.EmployeeEntity;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class PreviousCompanyDetails {
	@Id
	private int cid;
	private String companyname;
	private String fromdate;
	private String todate;
	@NotNull
	private String Designation;
	public PreviousCompanyDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PreviousCompanyDetails(int cid, String companyname, String fromdate, String todate, String designation) {
		super();
		this.cid = cid;
		this.companyname = companyname;
		this.fromdate = fromdate;
		this.todate = todate;
		Designation = designation;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getFromdate() {
		return fromdate;
	}
	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}
	public String getTodate() {
		return todate;
	}
	public void setTodate(String todate) {
		this.todate = todate;
	}
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
	
	
	

}
