package com.bhavna.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EmployeeDB")
public class Employee {
	
	 @Id
		@Column(name = "EmpId")
		private long EmpId;
	    
	    @Column(name = "EmpName")
		private String EmpName;
	    
	    @Column(name = "EmpSal")
		private long EmpSal;
	    
	    @Column(name = "DOJ")
		private String DOJ;
	    
	    @Column(name = "EmpStatus")
	    private String EmpStatus;
	    
	    @Column(name = "DeptId")
	    private int DeptId;
	    
	    @Column(name = "DeptName")
	    private String DeptName;
	    
	    public long getEmpId() {
			return EmpId;
		}

		public void setEmpId(long empId) {
			EmpId = empId;
		}

		public String getEmpName() {
			return EmpName;
		}

		public void setEmpName(String empName) {
			EmpName = empName;
		}

		public long getEmpSal() {
			return EmpSal;
		}

		public void setEmpSal(long empSal) {
			EmpSal = empSal;
		}

		public String getDOJ() {
			return DOJ;
		}

		public void setDOJ(String dOJ) {
			DOJ = dOJ;
		}

		public String getEmpStatus() {
			return EmpStatus;
		}

		public void setEmpStatus(String empStatus) {
			EmpStatus = empStatus;
		}
		
		public int getDeptId() {
			return DeptId;
		}
		
		public void setDeptId(int deptId) {
			DeptId = deptId;
		}
		
		public String getDeptName() {
			return DeptName;
		}
		
		public void setDeptName(String deptName) {
			DeptName = deptName;
		}

		public Employee() {
			super();
		}

}
