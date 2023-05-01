package com.example.learnspringboot.courses.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.learnspringboot.courses.bean.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

}
