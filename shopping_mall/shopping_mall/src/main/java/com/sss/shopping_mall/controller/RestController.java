package com.sss.shopping_mall.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sss.shopping_mall.model.Employee;
import com.sss.shopping_mall.service.EmployeeService;

@org.springframework.web.bind.annotation.RestController



public class RestController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/")
	public String hello() {
		return "welcomepage";
	}
	
	@GetMapping("/save-employee")
	public String saveEmployee(@RequestParam String username, @RequestParam String fullname, @RequestParam String address, @RequestParam int salary, @RequestParam String password) {
		Employee employee= new Employee(username, fullname, address, salary, password);
	employeeService.saveMyEmployee(employee);
		return "Employee Saved";
	}
	
}
