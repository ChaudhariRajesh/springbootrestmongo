package com.example.springbootrestmongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "subject")
public class Subject {

	@Id
	private int id; // Unique identifier for the subject

	private String name; // Name of the subject

	private int marks; // Marks associated with the subject

	//The constructors, getters, and setters for the fields.
	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Subject(int id, String name, int marks) {
		super();
		this.id = id;
		this.name = name;
		this.marks = marks;
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

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + ", marks=" + marks + "]";
	}

}


