package com.wipro.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.entity.Employee;

import lombok.Setter;

@Transactional @Setter
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public void saveEmployee(Employee employee) {
		
		 sessionFactory.getCurrentSession().persist(employee);
 
	}

	@Override
    public List<Employee> getAllEmployees() {
        return sessionFactory.getCurrentSession().createQuery("from Employee", Employee.class).list();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return sessionFactory.getCurrentSession().get(Employee.class, id);
    }

    @Override
    public void updateEmployee(Employee employee) {
        sessionFactory.getCurrentSession().merge(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee = getEmployeeById(id);
        if (employee != null) {
            sessionFactory.getCurrentSession().remove(employee);
        }
    }
}
