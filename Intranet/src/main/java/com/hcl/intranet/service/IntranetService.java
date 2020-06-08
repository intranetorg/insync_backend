package com.hcl.intranet.service;

import java.util.List;

import com.hcl.intranet.beans.Employee;

public interface IntranetService {

	public List<Employee> getEmployees();

	public Employee getEmployee(String sapID);

	public Employee addEmployee(Employee employee);

	public Employee updateEmployee(Employee employee);

	public boolean removeEmployee(String sapId);
}
