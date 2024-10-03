package com.wipro;


import com.wipro.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class App {

    public static void main(String[] args) {
        // Load configuration and build session factory
        SessionFactory sessionFactory = buildSessionFactory();

        // Open session
        Session session = sessionFactory.openSession();

        // Begin transaction
        Transaction transaction = session.beginTransaction();

        // Create a new Student
        Student student = Student.builder().stname("sanket").build();
        
        session.persist(student);

        // Commit the transaction
        transaction.commit();

        // Close the session
        session.close();

        // Close the session factory
        sessionFactory.close();

        System.out.println("Student saved successfully!");
    }

    private static SessionFactory buildSessionFactory() {
        // Create a Configuration object
        Configuration configuration = new Configuration();

        // Set Hibernate properties
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        properties.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/wipro");
        properties.put("hibernate.connection.username", "root");
        properties.put("hibernate.connection.password", "root");

        configuration.setProperties(properties);
        configuration.addAnnotatedClass(Student.class); // Register your Employee entity

        // Build the SessionFactory
        return configuration.buildSessionFactory();
    }
}
