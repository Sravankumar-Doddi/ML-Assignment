package com.bhavna.employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeService {
	
	Employee emp1 = new Employee("Sravankumar",25000.00,"Hyderabad");
	Employee emp2 = new Employee("Rajinikanth",30000.00,"Hyderabad");
	Employee emp3 = new Employee("Sathish",30000.00,"Hyderabad");
	Employee emp4 = new Employee("Narsimha",35000.00,"Hyderabad");
	Employee emp5 = new Employee("Naresh",35000.00,"Noida");
	Employee emp6 = new Employee("Raghu",40000.00,"Noida");
	Employee emp7 = new Employee("Mallikarjun",40000.00,"Noida");
	Employee emp8 = new Employee("Srikanth",50000.00,"Delhi");
	Employee emp9 = new Employee("Thrived",150000.00,"Delhi");
	Employee emp10 = new Employee("Mahesh",125000.00,"Hyderabad");

	List<Employee> list = new ArrayList();
	
	public void getDetails() {
		
		list.add(emp1);
		list.add(emp2);
		list.add(emp3);
		list.add(emp4);
		list.add(emp5);
		list.add(emp6);
		list.add(emp7);
		list.add(emp8);
		list.add(emp9);
		list.add(emp10);
		
		// *.Using Streams find the employee count whose name starts with ""S""
		long nameS = list.stream().filter(s->s.getName().startsWith("S")).count();
		System.out.println("Employees count whose names starts with 'S': "+nameS);
		
		//*.Using Parallel Stream Print all the Employees with location ""Hyderabad""
		List<Employee> locH =list.parallelStream().filter(l->l.getLocation() == "Hyderabad").toList();
		System.out.println("Employees whose location is 'Hyderabad': "+locH);
		
		//*.Get Location and employees in that location output : Map<String, List<Employees>> 
		//  ex : key : "Hyderbad" value : Employees who reside in Hyderabad
	    Map<String, List<Employee>> map = new HashMap<>();
	    map = list.stream().collect(Collectors.groupingBy(Employee :: getLocation));
	    System.out.println("Group by location");
	    System.out.println(map);
	    
	    //*.Using Streams Check if any Employee's Salary is > 100000
		List<Employee> sal = list.stream().filter(s->s.getSalary() > 100000).toList();
		if (sal.size() > 0) {
			System.out.println("Employee whose salary is greater than 100000: "+sal);
		}
		else {
			System.out.println("No record found");
		}
		
		//* Using Lambds's Write a logic to sort EmployeeList based on Name & location"
		 list.sort((Employee n1, Employee n2)->n1.getName().compareTo(n2.getName())); 
		 System.out.println("\s Sorted Employees list based on Names: ");
		 list.forEach(n -> System.out.println(n));
		
		 list.sort((Employee l1, Employee l2)->l1.getLocation().compareTo(l2.getLocation()));
		 System.out.println("\s Sorted Employees list based on location");
		 list.forEach(l -> System.out.println(l));
		 
	}
	
}
