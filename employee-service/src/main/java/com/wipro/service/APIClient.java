package com.wipro.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wipro.dto.DepartmentDto;

//@FeignClient(url = "http://localhost:9092",value="DEPARTMENT-SERVICE")
@FeignClient(name="DEPARTMENT-SERVICE")
public interface APIClient {
	@GetMapping("api/department/{departmentCode}")
	public DepartmentDto getDepartmentByCode(@PathVariable("departmentCode") String x);

}
