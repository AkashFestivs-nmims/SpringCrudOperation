package com.example.SpringCrudOperation.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringCrudOperation.Bean.Employee;
import com.example.SpringCrudOperation.Service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		System.out.println("Inside employees--->");
		return employeeService.findAll();
	}
	
	@GetMapping("/employee/{id}")
	public Employee findById(@PathVariable int id) {
		
		System.out.println("Inside findById method----"+id);
		return employeeService.findById(id);
	}
	
	@DeleteMapping("/employee/{id}")
	public int deleteById(@PathVariable int id) {
		System.out.println("Inside deleteById Method ---"+id);
		
		return employeeService.deleteById(id);
		
	}
	
	@PostMapping("/employees")
	public String save(@RequestBody Employee e) {
		System.out.println("Inside save method---"+ e);
		return employeeService.save(e)+" Employee(s) saved successfully";
	}
	
	@PutMapping("/employee/{id}")
	public String updateEmployee(@RequestBody Employee e,@PathVariable int id) {
		System.out.println("Inside update Employee method------"+e + "Id is---"+id);
		return employeeService.update(e, id)+ "Employee updated sucessfully";
		
	}
}
