package com.wipro;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wipro.dao.EmployeeDAO;
import com.wipro.entity.Employee;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("appcontext.xml");

        EmployeeDAO employeeDAO = (EmployeeDAO)context.getBean("dao");

        // Creating a new employee
        Employee employee = new Employee();
        employee.setName("mobina");
        employee.setDepartment("IT");
        employeeDAO.saveEmployee(employee);

        // Fetching the saved employee
       Employee savedEmployee = employeeDAO.getEmployeeById(employee.getId());
        System.out.println("Saved Employee: " + savedEmployee.getName());
    }
}

