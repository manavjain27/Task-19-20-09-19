package com.wp.entities;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
public class Emp {

		@Id
		private int eno;
		
		@Pattern(regexp="[a-zA-Z]*", message="Only Alphabates Allowed")
		@Size(min=2,max=10, message="Your Name Is Invalid , Please Use 2-10 Chars only")
		private String ename;
		
		
		private int sal;
		
		
		public Emp(int eno) {
			super();
			this.eno = eno;
		}
		
		public int getEno() {
			return eno;
		}
		public void setEno(int eno) {
			this.eno = eno;
		}
		public String getEname() {
			return ename;
		}
		public void setEname(String ename) {
			this.ename = ename;
		}
		public int getSal() {
			return sal;
		}
		public void setSal(int sal) {
			this.sal = sal;
		}
	
		public Emp() {
			super();
		}

		public Emp(int eno, String ename, int sal) {
			super();
			this.eno = eno;
			this.ename = ename;
			this.sal = sal;
		}

		@Override
		public String toString() {
			return "Emp [eno=" + eno + ", ename=" + ename + ", sal=" + sal + "]";
		}
		
		
		
		
		

	}


