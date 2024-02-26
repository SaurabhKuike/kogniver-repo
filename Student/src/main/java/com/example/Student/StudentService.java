package com.example.Student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	@Autowired
	private StudentRepository repo;
	
	public void insertStudent(Student s) {
		
		Student insert = repo.insert(s);
		System.out.println("student inserted:"+insert);
	}
	
	public Student getStudent(int roll)
	{
		Optional<Student> byId = repo.findById(roll);
		return byId.get();
	}
	
	public List<Student> getAllStudent() {
		List<Student> all = repo.findAll();
		return all;
	}
	
	public Student deleteStudent(int roll) {
		Optional<Student> s=repo.findById(roll);
		repo.deleteById(roll);
		return s.get();
	}
	
	
}
