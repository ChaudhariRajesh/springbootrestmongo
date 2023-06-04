package com.example.springbootrestmongo.service;

import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import com.example.springbootrestmongo.model.Student;
import com.example.springbootrestmongo.model.Subject;
import com.example.springbootrestmongo.repository.StudentRepository;
import org.mockito.junit.jupiter.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

	@Mock
	private StudentRepository repository;
		
	private StudentService service;
	
	@BeforeEach
	private void setup() {
		this.service = new StudentService(this.repository);
	}
	
	@Test
	void testGetAllStudents() {
		service.getAllStudents();		
		verify(repository).findAll();
	}

	@Test
	void testFindStudentByName() {
		service.findStudentByName("Sanam");
		verify(repository).findByName("Sanam");
	}

	@Test
	void testSaveStudent() {
		Subject subject = new Subject(3,"Maths", 96);		
		List<Subject> list = new ArrayList<Subject>();
		list.add(subject);
		Student student = new Student(4,"Omar",22,"Uri", list);

		service.saveStudent(student);
		verify(repository).save(student);
	}

	@Test
	void testFindStudentById() {
		service.findStudentById(4);
		verify(repository).findById(4);
	}

	@Test
	void testDeleteStudentById() {
		service.deleteStudentById(4);
		verify(repository).deleteById(4);
	}

}
