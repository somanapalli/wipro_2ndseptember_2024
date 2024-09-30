package com.wipro.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.entity.Student;

@RestController
public class WelcomeController {

	
	@RequestMapping(value = "/welcome",method = RequestMethod.GET)
	public String welcome()
	{
		return "welcome to springboot";
	}
	
	@RequestMapping(value = "/student", method=RequestMethod.GET)
	public Student getStudentData()
	{
		
		Student student = new Student();
		student.setStid(100);
		student.setStname("rk");
		return student;
		
    }
}
