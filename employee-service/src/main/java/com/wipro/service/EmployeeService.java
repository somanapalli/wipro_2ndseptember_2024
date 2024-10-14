package com.wipro.service;

import com.wipro.dto.APIResponseDto;
import com.wipro.dto.EmployeeDto;

public interface EmployeeService {

	public EmployeeDto createEmployee(EmployeeDto empdto);
	public APIResponseDto getEmployeeById(Long id);
}
