package com.hcl.intranet.beans;

public class Employee {
	
	private String sapID;
	private String name;
	private String phoneNumber;
	
	public Employee(String sapID, String name, String phoneNumber) {
		this.sapID = sapID;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	public String getSapID() {
		return sapID;
	}
	public void setSapID(String sapID) {
		this.sapID = sapID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
