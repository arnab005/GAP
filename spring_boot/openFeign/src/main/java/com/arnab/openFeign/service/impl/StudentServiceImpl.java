package com.arnab.openFeign.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arnab.openFeign.dto.CourseDto;
import com.arnab.openFeign.dto.ResponseDto;
import com.arnab.openFeign.dto.StudentDto;
import com.arnab.openFeign.entity.Student;
import com.arnab.openFeign.repository.StudentRepository;
import com.arnab.openFeign.service.CourseService;
import com.arnab.openFeign.service.StudentService;
import com.arnab.openFeign.utils.AppUtils;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private CourseService courseService;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private AppUtils appUtils;
	
	@Override
	public StudentDto getStudent(Long sid) {
		return appUtils.entityToDto(studentRepository.findById(sid).get());
	}
	
	@Override
	public ResponseDto getStudentAndCourseDetail(Long sid, Long courseId, String courseName) {
		ResponseDto responseDto = new ResponseDto();
		StudentDto studentDto = appUtils.entityToDto(studentRepository.findById(sid).get());
		CourseDto courseDto = courseService.getCourseOptIn(courseId, courseName);
		responseDto.setStudentDto(studentDto);
		responseDto.setCourseDto(courseDto);
		return responseDto;
	}

	@Override
	public List<StudentDto> getAllStudents() {
		return appUtils.entityListToDto((List<Student>) studentRepository.findAll());
	}

	@Override
	public StudentDto saveStudent(StudentDto studentDto) {
		return appUtils.entityToDto(studentRepository.save(appUtils.dtoToEntity(studentDto)));
	}

	
}
