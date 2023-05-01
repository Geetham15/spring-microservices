package com.example.learnspringboot.courses.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.learnspringboot.courses.bean.Course;
import com.example.learnspringboot.courses.repository.CourseRepository;

@RestController
public class CourseController {
	
	@Autowired
	private CourseRepository repository;
	//http://localhost:8080/courses
	@GetMapping("/courses")
	public List<Course> getAllCourses() {
		return repository.findAll();
//		return Arrays.asList(new Course(1, "Learn Microservices","in28Minutes"),
//				new Course(2, "Learn Spring Boot","in28Minutes"));
	}
	
	//http://localhost:8080/courses/1
	@GetMapping("/courses/{id}")
	public Course getCourseDetails(@PathVariable long id) {
		Optional<Course> course = repository.findById(id);
		if(course.isEmpty()) {
			throw new RuntimeException("Course not found with id " + id);
		}
		return course.get();
		//return new Course(1, "Learn Microservices","in28Minutes");
	}
	
	//POST - Update/Replace a resource (/courses/1)
	@PostMapping("/courses")
	public void createCourse(@RequestBody Course course) {
		repository.save(course);
	}
	
	@PutMapping("/courses/{id}")
	public void updateCourse(@PathVariable long id, @RequestBody Course course) {
		repository.save(course);
	}
	
	@DeleteMapping("/courses/{id}")
	public void deleteCourse(@PathVariable long id) {
		repository.deleteById(id);
	}
}
