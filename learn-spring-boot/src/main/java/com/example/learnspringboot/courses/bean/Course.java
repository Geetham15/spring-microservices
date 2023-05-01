package com.example.learnspringboot.courses.bean;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

//@Entity(name="Course1")
@Entity
public class Course {
	@Id
	@GeneratedValue
	private long id;
	
	//@Column(name="course_name")
	private String name;
	
	private String author;
	
	//Entity should have a default constructor
	public Course() {}
	public Course(long id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}
	
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", author=" + author + "]";
	}
	
	
}
