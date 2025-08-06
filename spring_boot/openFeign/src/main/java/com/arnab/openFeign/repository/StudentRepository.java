package com.arnab.openFeign.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import com.arnab.openFeign.entity.Student;

public interface StudentRepository extends MongoRepository<Student, Long> {

}
