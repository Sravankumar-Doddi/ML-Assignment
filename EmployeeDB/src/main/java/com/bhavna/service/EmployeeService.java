package com.bhavna.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bhavna.entity.EmployeeEntity;

@Service
public interface EmployeeService {

	public List<EmployeeEntity> getAllEmployees();

	public List<EmployeeEntity> getAllEmployeesByPage(Integer pageNo, Integer pageSize);

	public Optional<EmployeeEntity> getEmployeeById(Integer id);

	public EmployeeEntity addEmployee(EmployeeEntity employee) throws IOException;

	public void deleteEmployee(Integer id);

	public void updateEmployee(Integer id, EmployeeEntity employee);

}
