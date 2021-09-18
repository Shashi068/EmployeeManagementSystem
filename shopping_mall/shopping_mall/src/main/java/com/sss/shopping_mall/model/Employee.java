package com.sss.shopping_mall.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {

	@Id
	private int id;
	private String username;
	private String fullname;
	private String address;
	private double salary;
	private String password;
	
	public Employee() {
		
	}
	
	
	
	public Employee(String username, String fullname, String address, double salary, String password) {
		super();
		this.username = username;
		this.fullname = fullname;
		this.address = address;
		this.salary = salary;
		this.password = password;
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String toString() {
		return "Employee [id=" + id + ", username=" + username + ", fullname=" + fullname + ", address=" + address
				+ ", salary=" + salary + ", password=" + password + "]";
	}
	
	
}
