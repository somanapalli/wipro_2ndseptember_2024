package com.wipro.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wipro.dto.APIResponseDto;
import com.wipro.dto.DepartmentDto;
import com.wipro.dto.EmployeeDto;
import com.wipro.entity.Employee;
import com.wipro.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public EmployeeDto createEmployee(EmployeeDto empdto) {
		// TODO Auto-generated method stub
		//convert dto to entity
		Employee employee = mapper.map(empdto, Employee.class);
		Employee savedEmployee = employeeRepository.save(employee);
		
		return mapper.map(savedEmployee, EmployeeDto.class);
		
	}

	@Override
	public APIResponseDto getEmployeeById(Long id) {
		
		Employee savedEmployee = employeeRepository.findById(id).get();
	
		ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:9091/api/department/" + savedEmployee.getDepartmentCode(), DepartmentDto.class);
		
		DepartmentDto departmentDto = responseEntity.getBody();
		
		
		/*DepartmentDto departmentDto = webClient.get()
		.uri("http://localhost:9090/api/department/" + savedEmployee.getDepartmentCode())
		.retrieve()
		.bodyToMono(DepartmentDto.class)
		.block();*/
		
		//DepartmentDto departmentDto = apiClient.getDepartmentByCode(savedEmployee.getDepartmentCode());
		
		
		
		EmployeeDto employeeDto = mapper.map(savedEmployee, EmployeeDto.class);
	
		APIResponseDto apiResponseDto = new APIResponseDto();
		
		apiResponseDto.setEmployeeDto(employeeDto);
		apiResponseDto.setDepartmentDto(departmentDto);
		
		
		return apiResponseDto;
		
		
	}

}
