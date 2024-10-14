package com.wipro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

	
	public Department findByDepartmentCode(String departmentCode);
}
