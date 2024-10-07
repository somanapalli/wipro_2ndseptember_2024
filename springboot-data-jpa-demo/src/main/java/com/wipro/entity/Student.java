package com.wipro.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
//@Table(name = "sanket")
public class Student {

	@Id
	//@Column(name="student_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer stid;
	
	private String stname;
}
