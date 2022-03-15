package com.bhavna.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bhavna.entity.EmployeeEntity;

@Service
public interface EmployeeService {

	public List<EmployeeEntity> getAllEmployees();

	public Optional<EmployeeEntity> getEmployeeByName(String name);

	public EmployeeEntity addEmployee(EmployeeEntity employee) throws IOException;

}
