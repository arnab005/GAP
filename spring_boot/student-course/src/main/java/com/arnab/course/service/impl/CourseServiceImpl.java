package com.arnab.course.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arnab.course.dto.CourseDto;
import com.arnab.course.repository.CourseRespository;
import com.arnab.course.service.CourseService;
import com.arnab.course.utils.AppUtils;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseRespository courseRespository;
	
	@Autowired
	private AppUtils appUtils;

	@Override
	public List<CourseDto> getCourses() {
		
		return appUtils.entityListToDtoList(courseRespository.findAll());
	}

	@Override
	public CourseDto addCourse(CourseDto courseDto) {
		return appUtils.entityToDto(courseRespository.save(appUtils.dtoToEntity(courseDto)));
	}

	@Override
	public CourseDto getCourseByCourseIdOrCourseName(Long courseId, String courseName) {
		return appUtils.entityToDto(courseRespository.findByCourseIdOrCourseName(courseId, courseName));
	}

}
