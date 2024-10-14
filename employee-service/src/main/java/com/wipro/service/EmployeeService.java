package com.wipro.service;

import com.wipro.dto.EmployeeDto;

public interface EmployeeService {

	public EmployeeDto saveEmployee(EmployeeDto dto);
	
	public EmployeeDto getEmployeeById(Long employeeId);
}
