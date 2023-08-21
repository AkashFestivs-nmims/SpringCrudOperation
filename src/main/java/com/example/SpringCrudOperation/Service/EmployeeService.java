package com.example.SpringCrudOperation.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringCrudOperation.Bean.Employee;
import com.example.SpringCrudOperation.Dao.EmployeeDAOImpl;

@Service("employeeService")
public class EmployeeService {

	@Autowired
	EmployeeDAOImpl employeeDAOImpl;
	
	public List<Employee> findAll() {
		return employeeDAOImpl.findAll();
	}
	
	public Employee findById(int id) {
		return employeeDAOImpl.findById(id);
	}
	
	public int deleteById(int id) {
		return employeeDAOImpl.deleteById(id);
	}
	
	public int save(Employee e) {
		return employeeDAOImpl.save(e);
	}
	
	public int update(Employee e, int id) {
		return employeeDAOImpl.update(e, id);
	}
	
	
}
