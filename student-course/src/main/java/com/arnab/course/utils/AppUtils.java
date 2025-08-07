package com.arnab.course.utils;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.arnab.course.dto.CourseDto;
import com.arnab.course.entity.Course;

@Component
public class AppUtils {

	@Autowired
	private ModelMapper modelMapper;
	
	public CourseDto entityToDto(Course course) {
		return modelMapper.map(course, CourseDto.class);
	}
	
	public List<CourseDto> entityListToDtoList(List<Course> courses) {
		TypeToken<List<CourseDto>> typeToken = new TypeToken<>(){};
		return modelMapper.map(courses, typeToken.getType());
	}
	
	public Course dtoToEntity(CourseDto courseDto) {
		return modelMapper.map(courseDto, Course.class);
	}
	
	public List<Course> dtoListToEntityList(List<CourseDto> courseDtos) {
		TypeToken<List<Course>> typeToken = new TypeToken<>(){};
		return modelMapper.map(courseDtos, typeToken.getType());
	}
	
	
}
