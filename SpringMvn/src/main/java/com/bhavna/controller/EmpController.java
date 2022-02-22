
package com.bhavna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bhavna.entity.Employee;
import com.bhavna.service.EmpService;

@RestController
public class EmpController {
	
	@Autowired
	EmpService empService;
	
    @RequestMapping(value = "/getActiveEmployees", method = RequestMethod.GET  ) 
    public List<Employee> getActiveEmployees() {
        return empService.getAllActiveEmployees();
    }
    
    @RequestMapping(value = "/getEmployee/{EmpId}", method = RequestMethod.GET)
    public Employee getEmployeeById(@PathVariable Long EmpId) {
    Employee emp = empService.getEmployeeById(EmpId);
    return emp;
    }
    
    @RequestMapping(value = "/test", method = RequestMethod.GET  ) 
    public String getTest() {
        return "Hello";
    }
}