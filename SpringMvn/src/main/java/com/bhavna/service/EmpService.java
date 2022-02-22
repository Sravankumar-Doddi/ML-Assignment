package com.bhavna.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bhavna.entity.Employee;

@Service
public interface EmpService {

	public List<Employee> getAllActiveEmployees();
	
	public Employee getEmployeeById(Long empId);

}
