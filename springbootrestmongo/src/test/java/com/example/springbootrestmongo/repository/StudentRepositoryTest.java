package com.example.springbootrestmongo.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.springbootrestmongo.model.*;
import java.util.*;

@SpringBootTest
class StudentRepositoryTest {

	@Autowired
	private StudentRepository repository;
	
	@Test
	void testFindByName() {
		Subject subject = new Subject(1,"Physice", 91);		
		List<Subject> list = new ArrayList<Subject>();
		list.add(subject);
		Student student = new Student(5,"Sanam",20,"Vihar Delhi", list);

		this.repository.save(student);
		List<Student> result = this.repository.findByName("Sanam");
		assertThat(result.get(0).getName()).isEqualTo(student.getName());
	}

	@Test
	void testFindByIdInt() {
		Subject subject = new Subject(2,"Biology", 85);		
		List<Subject> list = new ArrayList<Subject>();
		list.add(subject);
		Student student = new Student(7,"Nilesh",24,"Shimla", list);

		this.repository.save(student);
		Student result = this.repository.findById(7);
		assertThat(result.getId()).isEqualTo(student.getId());
		
	}

}
