package com.example.SpringCrudOperation.Bean;

public class Employee {

	private Long id;
	private String name;
	private String location;
	private String department;
	
//	public Employee(Long id, String name, String location, String department) {
//
//		this.id = id;
//		this.name = name;
//		this.location = location;
//		this.department = department;
//	}
	
	public Employee() {
		
	}

	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", location=" + location + ", department=" + department + "]";
	}
	
	
	
}
