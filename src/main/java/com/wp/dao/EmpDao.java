package com.wp.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.wp.entities.Emp;




@Repository
public class EmpDao implements EmpDaoSpecification {

		@Autowired
		private SessionFactory sessionfactory;
		
		public void saveEmployee(Emp emp)
		{
			
			Session session = sessionfactory.openSession();
			
			Transaction tr = session.beginTransaction();
			session.save(emp);
			tr.commit();
			session.close();
		}

		
		public Emp deleteEmployee(int code)
		{
		
			Session session=sessionfactory.openSession();
			Transaction tr = session.beginTransaction();
			Emp e=session.get(Emp.class,code);
			if(e==null)
				return null;
			session.delete(e);
			tr.commit();
			session.close();
			return e;
		}
		
		public Emp searchEmployee(int code)
		{
	
			Session session=sessionfactory.openSession();
			Emp e=session.get(Emp.class,code);
			session.close();
		
			 
			return e;
			
		}
		
		public Emp updateEmployee(Emp emp)
		{
			
			Session session=sessionfactory.openSession();
			Emp e=session.get(Emp.class,emp.getEno());
			e.setEname(emp.getEname());
			e.setSal(emp.getSal());
			session.update(e);
			Transaction tr = session.beginTransaction();
			tr.commit();
			session.close();
			return e;
			
		}
		
		public List<Emp> getAllEmployees()
		{
			
			Session session=sessionfactory.openSession();
			@SuppressWarnings("deprecation")
			Criteria cr=session.createCriteria(Emp.class);
			@SuppressWarnings("unchecked")
			List<Emp> emplist=cr.list();
			session.close();
			System.out.println(emplist);
			return emplist;
			
		}


		
	}


