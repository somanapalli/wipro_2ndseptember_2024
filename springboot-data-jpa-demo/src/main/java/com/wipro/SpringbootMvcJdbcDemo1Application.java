package com.wipro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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
		
		//Student student = new Student(104,"twinkle");
		
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
		
		 //repository.deleteById(104);
		 
		 //System.out.println("deleted successfully");
		
		
//		for(int i=1;i<=50;i++)
//		{
//			Student student = new Student();
//			student.setStname("Student " + i);
//			repository.save(student);
//		}
		//pagination and sorting
		
		int page = 0;
		int size = 10;
		String sortBy = "stname";
		
		Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
	
		Page<Student> studentPage =  repository.findAll(pageable);
	
		System.out.println("total students: " + studentPage.getTotalElements());
	    System.out.println("total pages: " + studentPage.getTotalPages());
	    
	    studentPage.getContent().forEach(student -> System.out.println("id:" + student.getStid() + " , Name: " + student.getStname()));
	    
	}

}

