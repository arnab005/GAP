package com.arnab.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arnab.course.dto.CourseDto;
import com.arnab.course.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@GetMapping("/all")
	public List<CourseDto> getAllCourses() {
		return courseService.getCourses();
	}
	
	@GetMapping("/fetchByCourseIdOrCourseName")
	public CourseDto getCourseByCourseIdOrName(@RequestParam Long courseId, @RequestParam String courseName) {
		return courseService.getCourseByCourseIdOrCourseName(courseId, courseName);
	}
	
	@PostMapping("/add")
	public ResponseEntity<CourseDto> addCourse(CourseDto courseDto) {
		return ResponseEntity.ok(courseService.addCourse(courseDto)) ;
	}
	
}
