package com.wipro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
