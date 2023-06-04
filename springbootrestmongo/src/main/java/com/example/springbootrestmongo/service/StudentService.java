package com.example.springbootrestmongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.springbootrestmongo.model.Student;
import com.example.springbootrestmongo.repository.StudentRepository;

@Service
public class StudentService {

	//The class is autowired with the StudentRepository to interact with the database.
	@Autowired
	private StudentRepository repository;

	public StudentService(StudentRepository repository) {
		super();
		this.repository = repository;
	}	
	
	public List<Student> getAllStudents() {
		// Retrieves all students from the repository
		return this.repository.findAll();
	}

	public List<Student> findStudentByName(String studentName) {
		// Retrieves a list of students by their name from the repository
		return this.repository.findByName(studentName);
	}
	
	public Student saveStudent(Student student) {
		// Saves a student in the repository
		return this.repository.save(student);
	}

	public Student findStudentById(int studentId) {
		// Retrieves a student by their ID from the repository
		return this.repository.findById(studentId);
	}

	public void deleteStudentById(int studentId) {
		// Deletes a student by their ID from the repository
		this.repository.deleteById(studentId);		
	}
	
}


