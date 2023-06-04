package com.example.springbootrestmongo.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "student")
public class Student {

	@Id
	private int id; // Unique identifier for the student

	private String name; // Name of the student

	private int age; // Age of the student

	private String address; // Address of the student

	private List<Subject> subjects; // List of subjects for the student

	//The constructors, getters, and setters for the fields.
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int id, String name, int age, String address, List<Subject> subjects) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.subjects = subjects;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + ", subjects="
				+ subjects + "]";
	}

}

