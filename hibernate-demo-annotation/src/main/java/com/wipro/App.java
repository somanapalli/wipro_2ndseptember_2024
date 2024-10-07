package com.wipro;

import com.wipro.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class App {

    private static EntityManagerFactory entityManagerFactory;

    public static void main(String[] args) {
        // Initialize the EntityManagerFactory
        entityManagerFactory = Persistence.createEntityManagerFactory("wipro-pu");

        // Add a new student
        addStudent("Bhavna");

        // Fetch all students
       // List<Student> students = fetchAllStudents();
       // students.forEach(student -> System.out.println(student.getStid() + ": " + student.getStname()));

        // Update a student
        //updateStudentName(1, "Twinkle Madan");

        // Fetch the updated student
        Student updatedStudent = fetchStudentById(1);
        System.out.println("Updated Student: " + updatedStudent.getStname());

        // Delete a student
       // deleteStudent(1);

        // Close the EntityManagerFactory
        entityManagerFactory.close();
    }

    private static void addStudent(String name) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Student student = Student.builder().stname(name).build();
        em.persist(student);

        transaction.commit();
        em.close();
        System.out.println("Student saved successfully!");
    }

    private static List<Student> fetchAllStudents() {
        EntityManager em = entityManagerFactory.createEntityManager();
        List<Student> students = em.createQuery("from Student", Student.class).getResultList();
        em.close();
        return students;
    }

    private static Student fetchStudentById(Integer stid) {
        EntityManager em = entityManagerFactory.createEntityManager();
        Student student = em.find(Student.class, stid);
        em.close();
        return student;
    }

    private static void updateStudentName(Integer stid, String newName) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Student student = em.find(Student.class, stid);
        if (student != null) {
            student.setStname(newName);
            em.merge(student);
            System.out.println("Student updated successfully!");
        } else {
            System.out.println("Student with ID " + stid + " not found.");
        }

        transaction.commit();
        em.close();
    }

    private static void deleteStudent(Integer stid) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Student student = em.find(Student.class, stid);
        if (student != null) {
            em.remove(student);
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student with ID " + stid + " not found.");
        }

        transaction.commit();
        em.close();
    }
}
