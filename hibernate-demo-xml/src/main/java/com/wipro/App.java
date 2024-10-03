package com.wipro;

import com.wipro.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

    public static void main(String[] args) {
        // Load configuration and build session factory
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        // Open session
        Session session = sessionFactory.openSession();

        // Begin transaction
        Transaction transaction = session.beginTransaction();

        // Create a new employee
        Employee employee = new Employee("sanket", "Engineering", 60000);
        session.persist(employee);

        // Commit the transaction
        transaction.commit();

        // Close the session
        session.close();

        // Close the session factory
        sessionFactory.close();

        System.out.println("Employee saved successfully!");
    }
}
