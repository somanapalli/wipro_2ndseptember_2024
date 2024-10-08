package com.wipro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wipro.entity.Department;
import com.wipro.entity.Employee;
import com.wipro.repository.DepartmentRepository;

@SpringBootApplication
public class SpringbootMvcJdbcDemo1Application implements CommandLineRunner{

	//@Autowired
	//private StudentRepository repository;
	
	@Autowired
	private DepartmentRepository repository;
	
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
		
//		int page = 0;
//		int size = 10;
//		String sortBy = "stname";
//		
//		Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
//	
//		Page<Student> studentPage =  repository.findAll(pageable);
//	
//		System.out.println("total students: " + studentPage.getTotalElements());
//	    System.out.println("total pages: " + studentPage.getTotalPages());
//	    
//	    studentPage.getContent().forEach(student -> System.out.println("id:" + student.getStid() + " , Name: " + student.getStname()));
	    
	    
	     Employee e1 = Employee.builder().name("sanket").build();
	     Employee e2 = Employee.builder().name("mobina").build();
	     
	     Department department = Department.builder().name("HR").build();
	     
	     department.getEmployees().add(e1);
	     department.getEmployees().add(e2);
	     
	     repository.save(department);
	     
	
	
	
	}

}

