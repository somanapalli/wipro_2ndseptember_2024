package com.wipro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.dto.DepartmentDto;
import com.wipro.service.DepartmentService;

@RestController
@RequestMapping("/api/department/")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping
	public DepartmentDto saveDepartment(@RequestBody DepartmentDto departmentDto)
	{
		return departmentService.saveDepartment(departmentDto);
	}
	
	@GetMapping("{departmentCode}")
	public DepartmentDto getDepartmentByCode(@PathVariable("departmentCode") String x)
	{
		return departmentService.getDepartmentByCode(x);
	}
	
}
