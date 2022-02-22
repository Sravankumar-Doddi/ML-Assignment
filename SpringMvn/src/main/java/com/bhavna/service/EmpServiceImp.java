package com.bhavna.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhavna.entity.Employee;
import com.bhavna.repository.EmpRepository;

@Service
public class EmpServiceImp implements EmpService {

	@Autowired
	private EmpRepository repository;

	@Override
	public List<Employee> getAllActiveEmployees() {
		List<Employee> list = new ArrayList<>();
//		repository.findAll().forEach(e -> list.add(e));
		list = (List<Employee>) repository.getAllActiveEmployees();
		return list;
	}

	@Override
	public Employee getEmployeeById(Long empId) {
		Employee emp = repository.findById(empId).get();
		return emp;
	}

}
