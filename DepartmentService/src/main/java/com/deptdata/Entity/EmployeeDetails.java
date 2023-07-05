package com.deptdata.Entity;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class EmployeeDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int empid;
	
	private String empname;
	@NotNull
	private String DOB;
	@NotNull
	private String Address;
	private String pan;
	private String aadhar;
	private String password;
	private String email;
	private String mobile;
	private int deptid;
	private String status;
	@OneToOne(cascade = CascadeType.ALL)
	private PreviousCompanyDetails pcdeatils;
	

	public EmployeeDetails(int empid, String empname, String dOB, String address, String pan, String aadhar,
			String password, String email, String mobile, int deptid, String status, PreviousCompanyDetails pcdeatils) {
		super();
		this.empid = empid;
		this.empname = empname;
		DOB = dOB;
		Address = address;
		this.pan = pan;
		this.aadhar = aadhar;
		this.password = password;
		this.email = email;
		this.mobile = mobile;
		this.deptid = deptid;
		this.status = status;
		this.pcdeatils = pcdeatils;
	}
	public EmployeeDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getAadhar() {
		return aadhar;
	}
	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public PreviousCompanyDetails getPcdeatils() {
		return pcdeatils;
	}
	public void setPcdeatils(PreviousCompanyDetails pcdeatils) {
		this.pcdeatils = pcdeatils;
	}
	@Override
	public String toString() {
		return "EmployeeDetails [empid=" + empid + ", empname=" + empname + ", DOB=" + DOB + ", Address=" + Address
				+ ", pan=" + pan + ", aadhar=" + aadhar + ", password=" + password + ", email=" + email + ", mobile="
				+ mobile + ", status=" + status + ", pcdeatils=" + pcdeatils + "]";
	}
	
	

}
