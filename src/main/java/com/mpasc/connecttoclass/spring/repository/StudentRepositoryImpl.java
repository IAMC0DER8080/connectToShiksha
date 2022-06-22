package com.mpasc.connecttoclass.spring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpasc.connecttoclass.spring.entity.Student;

@Service
public class StudentRepositoryImpl {

	@Autowired
	StudentRepository studentRepo;
	
	public Student getUser(String userId) {
		return studentRepo.findByUserId(userId);
	}
	
	public List<Student> getUserByClassId(Long classId) {
		return studentRepo.findByClassId(classId);
	}
	
}
