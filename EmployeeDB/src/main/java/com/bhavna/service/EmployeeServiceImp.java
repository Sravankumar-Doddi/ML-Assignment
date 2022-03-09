package com.bhavna.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	public List<EmployeeEntity> getAllEmployeesByPage(Integer pageNo, Integer pageSize) {
		Pageable paging = PageRequest.of(pageNo - 1, pageSize);
		Page<EmployeeEntity> pagedResult = employeeRepo.findAll(paging);
		return pagedResult.toList();
	}

	@Override
	public Optional<EmployeeEntity> getEmployeeById(Integer id) {
		return employeeRepo.findById(id);
	}

	@Override
	public EmployeeEntity addEmployee(EmployeeEntity employee) throws IOException {
		Optional<EmployeeEntity> emp = employeeRepo.findById(employee.getId());
		if (emp.isPresent()) {
			throw new IOException("Employe Already Exist");
		} else {
			return employeeRepo.save(employee);
		}
	}

	@Override
	public void deleteEmployee(Integer id) {
		employeeRepo.deleteById(id);
	}

	@Override
	public void updateEmployee(Integer id, EmployeeEntity employee) {
		if (employeeRepo.existsById(id)) {
			employeeRepo.save(employee);
		}
	}

}
