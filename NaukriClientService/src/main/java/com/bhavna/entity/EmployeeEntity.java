package com.bhavna.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EmployeeDatabase")
public class EmployeeEntity {

	@Column(name = "ID")
	private Integer id;

	@Id
	@Column(name = "NAME", unique = true)
	private String name;

	@Column(name = "AGE")
	private Integer age;

	@Column(name = "SALARY")
	private Integer salary;

	@Column(name = "JOBTITLE")
	private String jobTitle;

	@Column(name = "GENDER")
	private String gender;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "EmployeeEntity [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + ", jobTitle="
				+ jobTitle + ", gender=" + gender + "]";
	}

}
