package com.bhavna.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Employee {
	
	String conUrl="jdbc:sqlserver://localhost:1433;databaseName=demo;user=sa;password=Bhavna@123";
	
	Scanner scan = new Scanner(System.in);
	
	//1.fetch the data emplyeeid,employee name,employee sal,joining date of emp ,deptid, dept name using jdbc
	public void fetchingData() {
		try (Connection conn = DriverManager.getConnection(conUrl);
				Statement stat = conn.createStatement();) {
			//Fetching the Employee table 
			System.out.println("Create select Query to Fetch the Data from Employee Table: ");
			String fetchingEmpQuery = scan.nextLine(); 
			// String fetchingEmpQuery="SELECT * FROM EMP";
			ResultSet rset = stat.executeQuery(fetchingEmpQuery); 
			System.out.println("EMPID\tEMPNAME\tEMPSAL\t\tDOJ\t\tDEPTID");
			System.out.println("----------------------------------------");
			while (rset.next()) {
				System.out.println(rset.getString(1) + "\t" + rset.getString(2) + "\t" + rset.getString(3) + "\t"
						+ rset.getString(4) + "\t" + rset.getString(5));
			}

			// Fetching the Depariment Table 
			System.out.println("Create select Query to Fetch the Data from Employee Table: ");
			String fetchingDeptQuery = scan.nextLine(); 
			// String fetchingDeptDataQuery="SELECT * FROM DEPT";
			rset = stat.executeQuery(fetchingDeptQuery);
			System.out.println("DEPTID\t" + "DEPTNAME\t");
			System.out.println("----------------------------------------");
			while (rset.next()) {
				System.out.println(rset.getString(1) + "\t" + rset.getString(2));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	//2.save employee and department tables using jdbc
	
	public void insertEmpData() {
		try (	Connection conn = DriverManager.getConnection(conUrl);
				Statement stat = conn.createStatement();) {
			System.out.print("Enter EmpId: ");
			int empId = scan.nextInt();
			scan.nextLine();
			System.out.print("Enter EmpName: ");
			String empName = scan.nextLine();
			System.out.print("Enter EmpSalary: ");
			double sal = scan.nextDouble();
			scan.nextLine();
			System.out.print("Enter EmpDateOfJoining: ");
			String date = scan.nextLine();
			System.out.print("Enter DeptId: ");
			int deptId = scan.nextInt();
			String insertQuery = "Insert INTO Employee VALUES(" + empId + ",\'" + empName + "\'," + sal + ",\'" + date
					+ "\'," + deptId + ")";
			stat.executeUpdate(insertQuery);
			System.out.println("Record was inserted successfully! ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertDeptData() {
		try (	Connection conn = DriverManager.getConnection(conUrl);
				Statement stat = conn.createStatement()) {
			System.out.print("Enter deptId: ");
			int deptId = scan.nextInt();
			scan.nextLine();
			System.out.print("Enter deptName: ");
			String deptName = scan.nextLine();
			String insertQuery = "Insert INTO Department VALUES(" + deptId + ",\'" + deptName + "\')";
			stat.executeUpdate(insertQuery);
			System.out.println("Record was inserted successfully! ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//3.updating the employee table using jdbc
	public void updateEmpData() {
		try (Connection conn = DriverManager.getConnection(conUrl);
				Statement stat = conn.createStatement();) {
			String updateQuery = "UPDATE Employee SET EmpName=\'Sravn\' WHERE EMPID=1";
			stat.executeUpdate(updateQuery);
			System.out.println("ONE RECORD IS UPDATED! ");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 4. write a query for find the number of employees in each department
	//    whose employee sal greater than 30000.(fetch coulms dept name,count of emplyee)
	
	public void employeesCount() {
		try (Connection conn = DriverManager.getConnection(conUrl);
				Statement stat = conn.createStatement()) {
			System.out.println("Employees count in each Department whose salay is greater than 30000");
			String query = "select DeptName,count(*) as num from Department d inner join Employee e "
					        + "on e.DEPTID=d.DEPTID where EmpSal>=30000 group by DEPTNAME";
			ResultSet rs = stat.executeQuery(query);
			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2));
			}
			System.out.println("Executed Successfully: ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
