package com.mpasc.connecttoclass.spring.repository;

import org.springframework.beans.factory.annotation.Autowired;

import com.mpasc.connecttoclass.spring.entity.Teacher;

public class TeacherRepositoryImpl {
	
	@Autowired
	TeacherRepository teacherRepo;
	
	public Teacher findTeacher(String userId) {
		return teacherRepo.getByUserId(userId);
	}

}
