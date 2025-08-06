package com.arnab.openFeign.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.arnab.openFeign.dto.CourseDto;

//@FeignClient(name = "course-service", url = "localhost:8087/course")
@FeignClient(name = "http://COURSE-SERVICE/course")
public interface CourseService {
	
	@GetMapping("/fetchByCourseIdOrCourseName")
	public CourseDto getCourseOptIn(@RequestParam Long courseId, @RequestParam String courseName);

}
