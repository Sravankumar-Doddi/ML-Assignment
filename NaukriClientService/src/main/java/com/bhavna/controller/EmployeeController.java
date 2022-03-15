package com.bhavna.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhavna.entity.EmployeeEntity;
import com.bhavna.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Value("${domain}")
	private String msg;

	@GetMapping("/get")
	public String get() {
		return msg;
	}

	@Autowired
	EmployeeService empService;

	@GetMapping("/getAllEmployees")
	public List<EmployeeEntity> getAllEmployee() {
		return empService.getAllEmployees();
	}

	@GetMapping("/getEmployee/{name}" + "${domain}")
	public Optional<EmployeeEntity> getEmployeeByName(@PathVariable("name") String name) {
		return empService.getEmployeeByName(name);
	}

	@PostMapping("/addEmployee")
	public EmployeeEntity addEmployee(@RequestBody EmployeeEntity employee) throws IOException {
		return empService.addEmployee(employee);
	}

}
