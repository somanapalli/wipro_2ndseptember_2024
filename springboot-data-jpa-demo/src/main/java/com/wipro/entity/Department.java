package com.wipro.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @AllArgsConstructor  @Builder
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "department_id")
	private List<Employee> employees = new ArrayList<>();
	
	 
	
	public Department()
	{
		this.employees = new ArrayList<>();
	}
	
	public Department(String name)
	{
		this.name=name;
		this.employees = new ArrayList<>();
	}
	public List<Employee> getEmployees()
	{
		if(employees == null)
		{
			employees = new ArrayList<>();
		}return employees;
	}
}
