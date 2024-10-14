package com.wipro.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.dto.EmployeeDto;
import com.wipro.entity.Employee;
import com.wipro.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public EmployeeDto saveEmployee(EmployeeDto dto) {
		
		
		
		//convert dto to entity 
		Employee employee = mapper.map(dto, Employee.class);
		

		
		Employee savedEmployee = employeeRepository.save(employee);
		
		//convert entity to dto
		
		return mapper.map(savedEmployee, EmployeeDto.class);
		
	}

	

	@Override
	public EmployeeDto getEmployeeById(Long employeeId) {
		// TODO Auto-generated method stub
		Employee employee = employeeRepository.findById(employeeId).get();
		
		return mapper.map(employee, EmployeeDto.class);
	}

	

}
