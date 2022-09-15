package com.ems.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


public class Employee {
private long empId;
private String empName;
private double empSal;


//entity reference
Address address;   //HAS-A relationship/association


public long getEmpId() {
	return empId;
}


public String getEmpName() {
	return empName;
}


public double getEmpSal() {
	return empSal;
}


public Address getAddress() {
	return address;
}


public Employee(long empId, String empName, double empSal, Address address) {
	super();
	this.empId = empId;
	this.empName = empName;
	this.empSal = empSal;
	this.address = address;
}


public Employee() {
	super();
	// TODO Auto-generated constructor stub
}


public void setEmpName(String string) {
	// TODO Auto-generated method stub
	
}
   }
