package com.sss.shopping_mall.service;

import java.util.ArrayList;
import java.util.List;


import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sss.shopping_mall.model.Employee;
import com.sss.shopping_mall.repository.EmployeeRepositry;

@Service
@Transactional

public class EmployeeService {
	
	
	private final EmployeeRepositry employeeRepository;
	
	public EmployeeService(EmployeeRepositry employeeRepository) {
		this.employeeRepository=employeeRepository;
	}
	
	public void saveMyEmployee(Employee employee ) {
		employeeRepository.save(employee);
	}
	
	public List<Employee> showAllEmployees(){
		List<Employee> employees = new ArrayList<Employee>();
		for(Employee employee : employeeRepository.findAll()) {
			employees.add(employee);
		}
		
		return employees;
	}
	
	public void deleteMyEmployee(Integer id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
	}
	
	public Employee editEmployee() {
		return (Employee) employeeRepository.findAll();
	}
	
	public Employee findByUsernameAndPassword(String employeename, String password) {
		return employeeRepository.findByUsernameAndPassword(employeename, password);
	}

	}

	
		



