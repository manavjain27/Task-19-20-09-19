package com.wp.services;

import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;

import com.wp.entities.Emp;

public interface ServiceClassSpecification {

	public void addEmployee(Emp emp);
	public Emp removeEmployee(int code);
	public Emp searchEmp(int code);
	public Emp updateEmp(Emp emp);
	public List<Emp> viewAllEmployees();
}
