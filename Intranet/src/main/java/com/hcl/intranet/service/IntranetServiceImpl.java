package com.hcl.intranet.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hcl.intranet.beans.Employee;

@Service
public class IntranetServiceImpl implements IntranetService{
	
	static List<Employee> employees = new ArrayList<Employee>();
	
	static {
		Employee employee = new Employee("1", "test", "9");
		employees.add(employee);
	}
	
	@Override
	public List<Employee> getEmployees() {
		return (List<Employee>) employees;
	}

	@Override
	public Employee getEmployee(String sapID) {				
		Employee employee = employees.stream().filter(empl -> empl.getSapID().equals(sapID)).findAny().orElse(null);
		if (Objects.nonNull(employee)) {
			return employee;
		}
		
		return null;
	}

	@Override
	public Employee addEmployee(Employee employee) {
		Employee employee1 = employees.stream().filter(empl -> empl.getSapID().equals(employee.getSapID())).findAny().orElse(null);

		if (Objects.nonNull(employee1)) {
			return null;
		}
		employees.add(employee);
		return employee;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Employee employee1 = employees.stream().filter(empl -> empl.getSapID().equals(employee.getSapID())).findAny().orElse(null);
		if (Objects.nonNull(employee1)) {
			employees.remove(employee1);
		}else {
			return null;
		}
		employees.add(employee);
		return employee;
	}

	@Override
	public boolean removeEmployee(String sapID) {
		
		Employee employee = employees.stream().filter(empl -> empl.getSapID().equals(sapID)).findAny().orElse(null);
		if (Objects.nonNull(employee)) {
			return employees.remove(employee);
		}
		return false;
	}
	
	

}
