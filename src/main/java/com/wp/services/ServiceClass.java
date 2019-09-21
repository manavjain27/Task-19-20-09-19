package com.wp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.wp.dao.EmpDaoSpecification;
import com.wp.entities.Emp;

@Service
public class ServiceClass implements ServiceClassSpecification {
	
	@Autowired
	private EmpDaoSpecification dao;
	
	public void addEmployee(Emp emp)
	{
		dao.saveEmployee(emp);
	}

	
	public Emp removeEmployee(int code)
	{
		Emp e=dao.deleteEmployee(code);
		return e;
	}
	
	public Emp searchEmp(int code)
	{
		Emp e=dao.searchEmployee(code);
		return e;
		
	}
	
	public Emp updateEmp(Emp emp)
	{
		Emp e=dao.updateEmployee(emp);
		return e;
		
	}
	
	public List<Emp> viewAllEmployees()
	{
		List<Emp> empList=dao.getAllEmployees();
		return empList;
		
	}

}
