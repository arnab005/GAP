package com.arnab.openFeign.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arnab.openFeign.dto.ResponseDto;
import com.arnab.openFeign.dto.StudentDto;
import com.arnab.openFeign.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/getById/{sid}")
	public ResponseEntity<StudentDto> getStudentById(@PathVariable Long sid){
		return ResponseEntity.ok(studentService.getStudent(sid));
	}
	
	@GetMapping("/getStudentByIdAndOptCourseDetail")
	public ResponseEntity<ResponseDto> getStudentById(@RequestParam Long sid, @RequestParam Long courseId, @RequestParam String courseName){
		return ResponseEntity.ok(studentService.getStudentAndCourseDetail(sid, courseId, courseName));
	}
	
	@GetMapping("/allStudents")
	public ResponseEntity<List<StudentDto>> getAllStudents(){
		return ResponseEntity.ok(studentService.getAllStudents());
	}
	
	@PostMapping(value = "/save")
	public ResponseEntity<StudentDto> saveStudent(@RequestBody StudentDto studentDto) {
		return ResponseEntity.ok(studentService.saveStudent(studentDto));
	}
	
}
