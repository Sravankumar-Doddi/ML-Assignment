package com.bhavna.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bhavna.entity.EmployeeEntity;
import com.bhavna.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeService empService;

	@GetMapping("/getAllEmployees")
	public List<EmployeeEntity> getAllEmployee() {
		return empService.getAllEmployees();
	}

	@GetMapping("/getAllEmployeesByPage")
	public List<EmployeeEntity> getAllEmployeesByPage(
			@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
			@RequestParam(name = "size", required = false, defaultValue = "5") Integer size) {
		return empService.getAllEmployeesByPage(page, size);
	}

	@GetMapping("/getEmployee/{id}")
	public Optional<EmployeeEntity> getEmployeeById(@PathVariable Integer id) {
		return empService.getEmployeeById(id);
	}

	@PostMapping("/addEmployee")
	public EmployeeEntity addEmployee(@RequestBody EmployeeEntity employee) throws IOException {
		return empService.addEmployee(employee);
	}

	@DeleteMapping("/deleteEmployee/{id}")
	public void deleteEmployee(@PathVariable("id") Integer id) {
		empService.deleteEmployee(id);
	}

	@PutMapping("updateEmployee/{id}")
	public void updateEmployee(@PathVariable("id") Integer id, @RequestBody EmployeeEntity employee) {
		empService.updateEmployee(id, employee);
	}
}
