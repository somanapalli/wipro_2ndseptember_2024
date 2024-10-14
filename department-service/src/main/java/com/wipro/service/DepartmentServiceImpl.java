package com.wipro.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.dto.DepartmentDto;
import com.wipro.entity.Department;
import com.wipro.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public DepartmentDto saveDepartment(DepartmentDto dto) {
		
		//convert dto to entity 
		Department department = mapper.map(dto, Department.class);
		

		
		Department savedDepartment = departmentRepository.save(department);
		
		//convert entity to dto
		
		return mapper.map(savedDepartment, DepartmentDto.class);
		
	}

	@Override
	public DepartmentDto getDepartmentByCode(String departmentCode) {
		
		Department existingDepartment = departmentRepository.findByDepartmentCode(departmentCode);
		
		//convert entity to dto 
		return mapper.map(existingDepartment, DepartmentDto.class);
	}

}
