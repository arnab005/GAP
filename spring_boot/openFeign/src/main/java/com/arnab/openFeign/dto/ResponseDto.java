package com.arnab.openFeign.dto;

public class ResponseDto {

	private StudentDto studentDto;
	private CourseDto courseDto;
	
	public StudentDto getStudentDto() {
		return studentDto;
	}
	public void setStudentDto(StudentDto studentDto) {
		this.studentDto = studentDto;
	}
	public CourseDto getCourseDto() {
		return courseDto;
	}
	public void setCourseDto(CourseDto courseDto) {
		this.courseDto = courseDto;
	}
	
	
}
