package com.wipro;

import com.wipro.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Properties;
import java.util.List;

public class App {

    public static void main(String[] args) {
        // Load configuration and build session factory
        SessionFactory sessionFactory = buildSessionFactory();

        // Add a new student
        addStudent(sessionFactory, "bhavna");

        // Fetch all students
        List<Student> students = fetchAllStudents(sessionFactory);
        students.forEach(student -> System.out.println(student.getStid() + ": " + student.getStname()));

        // Update a student
        updateStudentName(sessionFactory, 2, "Twinkle Madan");

        // Fetch the updated student
        Student updatedStudent = fetchStudentById(sessionFactory, 1);
        System.out.println("Updated Student: " + updatedStudent.getStname());

        // Delete a student
        deleteStudent(sessionFactory, 1);

        // Close the session factory
        sessionFactory.close();
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
        configuration.addAnnotatedClass(Student.class); // Register your Student entity

        // Build the SessionFactory
        return configuration.buildSessionFactory();
    }

    // Method to add a new student
    private static void addStudent(SessionFactory sessionFactory, String name) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Student student = Student.builder().stname(name).build();
        session.persist(student);

        transaction.commit();
        session.close();
        System.out.println("Student saved successfully!");
    }

    // Method to fetch all students
    private static List<Student> fetchAllStudents(SessionFactory sessionFactory) {
        Session session = sessionFactory.openSession();
        List<Student> students = session.createQuery("from Student", Student.class).list();
        session.close();
        return students;
    }

    // Method to fetch a student by ID
    private static Student fetchStudentById(SessionFactory sessionFactory, Integer stid) {
        Session session = sessionFactory.openSession();
        Student student = session.get(Student.class, stid);
        session.close();
        return student;
    }

    // Method to update a student name by ID
    private static void updateStudentName(SessionFactory sessionFactory, Integer stid, String newName) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Student student = session.get(Student.class, stid);
        if (student != null) {
            student.setStname(newName);
            session.merge(student); // This will update the record in the database
            System.out.println("Student updated successfully!");
        } else {
            System.out.println("Student with ID " + stid + " not found.");
        }

        transaction.commit();
        session.close();
    }

    // Method to delete a student by ID
    private static void deleteStudent(SessionFactory sessionFactory, Integer stid) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Student student = session.get(Student.class, stid);
        if (student != null) {
            session.remove(student); // This will delete the record from the database
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student with ID " + stid + " not found.");
        }

        transaction.commit();
        session.close();
    }
}
