package com.wipro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wipro.entity.Student;
import com.wipro.repository.StudentRepository;

@SpringBootApplication
public class SpringbootMvcJdbcDemo1Application implements CommandLineRunner{

	@Autowired
	private StudentRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootMvcJdbcDemo1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Student student = new Student(104,"twinkle");
		
		//Student savedStudent = repository.save(student);
		
		//System.out.println(savedStudent);
		
		//repository.findAll().forEach(System.out::println);
	    
		//System.out.println(repository.findById(100).get());
		
//		Student savedStudent = repository.findById(100).get();
//		
//		savedStudent.setStname("rk");
//		
//		Student updatedStudent = repository.save(savedStudent);
//		System.out.println(updatedStudent);
		
		 repository.deleteById(104);
		 
		 System.out.println("deleted successfully");
	}

}
