package com.arnab.openFeign.utils;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.internal.bytebuddy.description.type.TypeVariableToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.arnab.openFeign.dto.StudentDto;
import com.arnab.openFeign.entity.Student;

@Component
public class AppUtils {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public StudentDto entityToDto(Student student) {
		return modelMapper.map(student, StudentDto.class);
	}
	
	public List<StudentDto> entityListToDto(List<Student> students) {
		TypeToken<List<StudentDto>> typeToken = new TypeToken<>() {};
		return modelMapper.map(students, typeToken.getType());
	}
	
	public Student dtoToEntity(StudentDto studentDto) {
		return modelMapper.map(studentDto, Student.class);
	}
	
	public List<Student> dtoListToEntity(List<StudentDto> studentDtos) {
		TypeToken<List<Student>> typeToken = new TypeToken<>() {};
		return modelMapper.map(studentDtos, typeToken.getType());
	}

}
