package com.example.springbootrestmongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootrestmongo.model.Student;
import com.example.springbootrestmongo.service.StudentService;

@RestController
@RequestMapping("/StudentDetails")
public class StudentController {

	@Autowired
	private StudentService service;
	
	@GetMapping("/")
	@ResponseBody
	public String getHome() {
		// Returns the home page message
		return "This is our home page";
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudents() {
		List<Student> list = this.service.getAllStudents();
		if (list.size() <= 0) {
			// Returns 404 NOT FOUND status if the student list is empty
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		// Returns the list of students with 200 OK status
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{studentName}")
	public ResponseEntity<List<Student>> getStudentByName(@PathVariable("studentName") String studentName) {
		List<Student> result = this.service.findStudentByName(studentName);
		if (result.isEmpty()) {
			// Returns 404 NOT FOUND status if no students with the given name are found
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		// Returns the list of students with 200 OK status
		return ResponseEntity.ok().body(result);
	}

	@PostMapping("/addstudent")
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
		try {
			Student result = this.service.saveStudent(student);
			// Returns the saved student with 200 OK status
			return ResponseEntity.ok().body(result);
		} catch (Exception e) {
			// Returns 500 INTERNAL SERVER ERROR status if an exception occurs
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}	
	
	@PutMapping("/update/{studentId}")
	public ResponseEntity<Student> updateStudentById(@PathVariable("studentId") int studentId, @RequestBody Student student) {
		try {
			Student st = this.service.findStudentById(studentId);
			if (st == null) {
				// Returns 404 NOT FOUND status if the student with the given ID is not found
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			// Updates the student details
			st.setName(student.getName());
			st.setAge(student.getAge());
			st.setAddress(student.getAddress());
			st.setSubjects(student.getSubjects());
			this.service.saveStudent(st);
			// Returns the updated student with 200 OK status
			return ResponseEntity.ok().body(st);
		} catch (Exception e) {
			// Returns 404 NOT FOUND status if an exception occurs
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@DeleteMapping("/delete/{studentId}")
	public ResponseEntity<Void> deleteStudentById(@PathVariable("studentId") int studentId) {
		try {
			this.service.deleteStudentById(studentId);
			// Returns 204 NO CONTENT status if the student is successfully deleted
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			// Returns 500 INTERNAL SERVER ERROR status if an exception occurs
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
}


