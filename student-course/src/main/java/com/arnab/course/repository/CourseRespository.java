package com.arnab.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arnab.course.entity.Course;

public interface CourseRespository extends JpaRepository<Course, Long> {

	public Course findByCourseIdOrCourseName(Long courseId, String courseName);

}
