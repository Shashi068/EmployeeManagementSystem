package com.sss.shopping_mall.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.sss.shopping_mall.model.Employee;
import com.sss.shopping_mall.service.EmployeeService;
@Controller
public class MyController {
	@Autowired
	EmployeeService employeeService;
	
	
	@RequestMapping("/welcome")
	public String Welcome(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOME");
		System.out.println("Welcome");
		return "welcomepage";
	}
	
	@RequestMapping("/register")
	public String registration(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_REGISTER");
		return "welcomepage";
	}

	
	
	@PostMapping("/save-employee")
	public String registerEmployee(@ModelAttribute Employee employee, BindingResult bindingResult, HttpServletRequest request) {
	employeeService.saveMyEmployee(employee);
		request.setAttribute("mode", "MODE_HOME");
		return "welcomepage";
	
	}

	@GetMapping("/show-employees")
	public String showAllEmployees(HttpServletRequest request) {
		request.setAttribute("employees", employeeService.showAllEmployees());
		request.setAttribute("mode", "ALL_EMPLOYEES");
		return "welcomepage";
	}
	@SuppressWarnings("unused")
	@GetMapping("/delete-employee/{id}")
	public void deleteEmployee(@PathVariable ("id") Integer id, Model model) {
		@SuppressWarnings("unchecked")
		Employee employee=((List<Employee>) employeeService).get(id);
		employeeService.deleteMyEmployee(id);
		
		
	}
	
	@RequestMapping("/edit-employee/{id}")
	public String editEmployee(@RequestParam Integer id,HttpServletRequest request) {
		request.setAttribute("employee", employeeService.editEmployee());
		request.setAttribute("mode", "MODE_UPDATE");
		return "welcomepage";
		
	}
	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_LOGIN");
		return "welcomepage";
	}
	

	
	
	
	@RequestMapping ("/login-employee")
	public String loginEmployee(@ModelAttribute Employee employee, HttpServletRequest request) {
		if(employeeService.findByUsernameAndPassword(employee.getUsername(), employee.getPassword())!=null) {
			return "homepage";
		}
		else {
			request.setAttribute("error", "Invalid Username or Password");
			request.setAttribute("mode", "MODE_LOGIN");
			return "welcomepage";
			
		}
	}	

		
	}

