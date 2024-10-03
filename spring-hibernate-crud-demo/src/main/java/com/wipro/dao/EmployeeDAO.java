package com.wipro.dao;



import java.util.List;

import com.wipro.entity.Employee;

public interface EmployeeDAO {
    void saveEmployee(Employee employee);
    
    List<Employee> getAllEmployees();
    
    Employee getEmployeeById(Long id);
    
    void updateEmployee(Employee employee);
    
    void deleteEmployee(Long id);
}
