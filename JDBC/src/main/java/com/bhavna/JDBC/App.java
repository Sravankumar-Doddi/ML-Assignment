package com.bhavna.JDBC;

import java.util.Scanner;

public class App 
{
	
    public static void main( String[] args )
    {
        Employee emp = new Employee();

        Scanner scan = new Scanner(System.in);
        char condition = 'n';
        do {
			System.out.println("Enter 1 fetch the data from Employee table and Deparmrnt table: ");
			System.out.println("Enter 2 insert the data in Employee table: ");
			System.out.println("Enter 3 insert the data in Department table: ");
			System.out.println("Enter 4 update the date: ");
			System.out.println("Enter 5 get Employee count in each Department whose salary in greater than 30000");
			int choice =  scan.nextInt();
			
			switch (choice) {
			case (1):
				emp.fetchingData();
				break;
			case (2):
				 emp.insertEmpData();
			     break;
			case (3):
				emp.insertDeptData();
				break;
			case (4):
				emp.updateEmpData();
			     break;
			case (5):
				emp.employeesCount();
			     break;
			default:
				System.out.println("Select the Given Option!!!");
				break;
			}
			System.out.println("do you want to continue enter y/n ");
			condition = scan.next().charAt(0);
			if (condition == 'n' ) {
				System.out.println("Program has been terminated Thank you!!!");
				break;
			}
			
		} while (condition == 'y');
    }
}
