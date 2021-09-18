package com.sss.shopping_mall.repository;

import org.springframework.data.repository.CrudRepository;
import com.sss.shopping_mall.model.Employee;



public interface EmployeeRepositry extends CrudRepository<Employee,Integer> {

	Employee findByUsernameAndPassword(String employeename, String password);

	
	
	}
