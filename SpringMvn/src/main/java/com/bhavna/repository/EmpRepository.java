
package com.bhavna.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.bhavna.entity.Employee;

@Repository
public interface EmpRepository extends CrudRepository<Employee, Long>{

	@Query(value = "SELECT * FROM EmployeeDB WHERE EmpStatus = 'Active'", nativeQuery = true)
	Collection<Employee> getAllActiveEmployees();

}