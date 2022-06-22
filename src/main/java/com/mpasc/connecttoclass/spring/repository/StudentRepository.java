package com.mpasc.connecttoclass.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mpasc.connecttoclass.spring.entity.Student;

public interface StudentRepository extends JpaRepository<Student, String>{
	
	Student findByUserId(String userId);
	
	List<Student> findByClassId(Long classId);

}
