package com.wipro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.dto.EmployeeDto;
import com.wipro.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping
	public EmployeeDto saveEmployee(@RequestBody EmployeeDto employeeDto)
	{
		return employeeService.saveEmployee(employeeDto);
	}
	
	@GetMapping("{id}")
	public EmployeeDto getEmployeeById(@PathVariable("id") Long x)
	{
		return employeeService.getEmployeeById(x);
	}
	
}
