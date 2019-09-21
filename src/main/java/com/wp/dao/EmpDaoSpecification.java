package com.wp.dao;

import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;

import com.wp.entities.Emp;

public interface EmpDaoSpecification {

	public void saveEmployee(Emp emp);
	public Emp deleteEmployee(int code);
	public Emp searchEmployee(int code);
	public Emp updateEmployee(Emp emp);
	public List<Emp> getAllEmployees();
}
