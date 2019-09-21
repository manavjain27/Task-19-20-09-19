package com.wp.controller;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wp.entities.Emp;
import com.wp.services.ServiceClassSpecification;



@Controller
public class HibernateController {
	
	@Autowired
	private ServiceClassSpecification serviceclass;


	@RequestMapping("saveinputform")
	public ModelAndView showSaveEmplForm()
	{
		Emp emp=new Emp();
		ModelAndView mv=new ModelAndView("saveEmp");
		mv.addObject("info",emp);
		return mv;
		
	}
	
	@RequestMapping("deleteinputform")
	public String showDeleteEmplForm()
	{
		return "deleteEmp";
	}
	
	@RequestMapping("searchinputform")
	public String showSearchEmplForm()
	{
		return "searchEmp";
	}
	
	@RequestMapping("updateinputform")
	public String showUpdateEmplNoForm()
	{
		return "empNoUpdate";
	}
	
	
	@RequestMapping("showFetchedForm")
	public ModelAndView showUpdateEmpForm(@RequestParam("eno") int code) {
		
		
		Emp e=serviceclass.searchEmp(code);
		ModelAndView mv = new ModelAndView("updateEmp");
		mv.addObject("info", e);
		return mv;
	}	 
	
	@RequestMapping("save")
	public ModelAndView saveEmployee(@Valid @ModelAttribute("info") Emp emp,BindingResult result) {
		
		if(result.hasErrors())
		{
			ModelAndView mv = new ModelAndView("saveEmp");
			return mv;
		}
		serviceclass.addEmployee(emp);
		ModelAndView mv = new ModelAndView("addedEmpdetails");
		return mv;
	}	 
	
	@RequestMapping("delete")
	public ModelAndView deleteEmployee(@RequestParam("eno") int code)
	{
		Emp e=serviceclass.removeEmployee(code);
		if(e!=null)
		{

		ModelAndView mv=new ModelAndView("deletedEmpdetails");
		mv.addObject("info",e);
		return mv;
		}
		else
		{
			ModelAndView mv=new ModelAndView("deleteEmp");
			mv.addObject("deleteErr","Cannot Delete");
			
			return mv;
		}
	}
	
	
	@RequestMapping("deleteEmp")
	public ModelAndView deleteEmployee1(@RequestParam("eno") int code)
	{
		Emp e=serviceclass.removeEmployee(code);
		if(e!=null)
		{

		ModelAndView mv=new ModelAndView("redirect:viewallEmployees");
		mv.addObject("info",e);
		return mv;
		}
		else
		{
			ModelAndView mv=new ModelAndView("deleteEmp");
			mv.addObject("deleteErr","Cannot Delete");
			
			return mv;
		}
	}
	
	@RequestMapping("search")
	public ModelAndView searchEmployee(@RequestParam("eno") int code)
	{
		Emp e=serviceclass.searchEmp(code);
		ModelAndView mv=new ModelAndView("searchedEmpdetails");
		mv.addObject("info",e); 
		return mv;
	}
	
	@RequestMapping("update")
	public ModelAndView updateEmployee(@Valid @ModelAttribute ("info") Emp emp,BindingResult result)
	{
	
		if(result.hasErrors())
		{
			ModelAndView mv=new ModelAndView("updateEmp");
			return mv;
		}
		Emp e=serviceclass.updateEmp(emp);
		
		ModelAndView mv=new ModelAndView("updatedEmpdetails");
		mv.addObject("info", e);
		return mv;
	}
	
	@RequestMapping("viewallEmployees")
	public ModelAndView showAllEmployees()
	{
		List<Emp> empList=serviceclass.viewAllEmployees();
		ModelAndView mv=new ModelAndView("ViewEmpDetails");
		mv.addObject("empList", empList);
		return mv;
		
	}
}
