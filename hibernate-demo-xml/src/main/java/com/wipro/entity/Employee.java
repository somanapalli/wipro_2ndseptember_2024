package com.wipro.entity;


public class Employee {

	    private int id;
	    private String name;
	    private String department;
	    private double salary;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDepartment() {
			return department;
		}
		public void setDepartment(String department) {
			this.department = department;
		}
		public double getSalary() {
			return salary;
		}
		public void setSalary(double salary) {
			this.salary = salary;
		}
		public Employee(String name, String department, double salary) {
			super();
			
			this.name = name;
			this.department = department;
			this.salary = salary;
		}
		public Employee() {
			super();
		}
	    
	    
}
