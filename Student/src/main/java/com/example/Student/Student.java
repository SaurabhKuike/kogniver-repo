package com.example.Student;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Component
@Document(collection = "stud")
@Data
public class Student {

	private String name;
	private String pno;
	private String gender;
	@Id
	private Integer rollNumber;

}
