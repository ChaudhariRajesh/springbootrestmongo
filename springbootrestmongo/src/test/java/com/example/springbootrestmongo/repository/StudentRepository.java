package com.example.springbootrestmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.springbootrestmongo.model.Student;

public interface StudentRepository extends MongoRepository<Student, Integer>{

	List<Student> findByName(String name);

	Student findById(int id);
}
