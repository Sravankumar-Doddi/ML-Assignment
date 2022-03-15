package com.bhavna.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhavna.entity.EmployeeEntity;
import com.bhavna.repository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepo;

	public List<EmployeeEntity> getAllEmployees() {
		return employeeRepo.findAll();
	}

	@Override
	public Optional<EmployeeEntity> getEmployeeByName(String name) {
		return employeeRepo.findById(name);
	}

	@Override
	public EmployeeEntity addEmployee(EmployeeEntity employee) throws IOException {
		return employeeRepo.save(employee);
	}

}
