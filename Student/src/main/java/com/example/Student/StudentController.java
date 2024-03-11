package com.example.Student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	@Autowired
	private StudentService service;
	
	@PostMapping("/insertstudent")
	public ResponseEntity<Student> insertstudent(@RequestBody Student s) {
		service.insertStudent(s);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getstudent/{id}")
	public ResponseEntity<Student> getstudentbyid(@PathVariable("id")int id) {
		Student student = service.getStudent(id);
		return new ResponseEntity<>(student,HttpStatus.OK);
	}
	
	@GetMapping("/getallstudent")
	public ResponseEntity<List<Student>> getAllStudent(){
		List<Student> allStudent = service.getAllStudent();
		return new ResponseEntity<>(allStudent,HttpStatus.OK);
	}
	
	@DeleteMapping("/deletestudent/{id}")
	public ResponseEntity<Student> deleteStudent(@PathVariable("id")int id){
		Student deleteStudent = service.deleteStudent(id);
		return new ResponseEntity<>(deleteStudent,HttpStatus.GONE);
	}
	
	@GetMapping("/name")
	public String getname(@RequestHeader("user")String user)
	{
		return "My Name is : "+user;
	}
}
