package com.wipro.service;

import com.wipro.dto.DepartmentDto;

public interface DepartmentService {

	public DepartmentDto saveDepartment(DepartmentDto dto);
	
	public DepartmentDto getDepartmentByCode(String departmentCode);
}
