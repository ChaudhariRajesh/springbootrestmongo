package com.example.springbootrestmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.springbootrestmongo.model.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, Integer> {

	List<Student> findByName(String name); // Custom query method that retrieves a list of students by their name

	Student findById(int id); // Custom query method that retrieves a student by their ID
}


