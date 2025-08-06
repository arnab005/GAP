package com.arnab.openFeign.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.arnab.openFeign.dto.ResponseDto;
import com.arnab.openFeign.dto.StudentDto;

public interface StudentService {

	public StudentDto getStudent(Long sid);
	
	public List<StudentDto> getAllStudents();

	public StudentDto saveStudent(StudentDto studentDto);

	ResponseDto getStudentAndCourseDetail(Long sid, Long courseId, String courseName);
}
