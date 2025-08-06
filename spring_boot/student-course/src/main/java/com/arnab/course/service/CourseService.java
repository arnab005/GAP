package com.arnab.course.service;

import java.util.List;



import com.arnab.course.dto.CourseDto;

public interface CourseService {
	
	public List<CourseDto> getCourses();
	
	public CourseDto getCourseByCourseIdOrCourseName(Long CourseId, String courseName);

	public CourseDto addCourse(CourseDto courseDto);

}
