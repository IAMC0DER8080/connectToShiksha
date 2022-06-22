package com.mpasc.connecttoclass.spring.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpasc.connecttoclass.spring.entity.AssignmentEntity;

@Service
public class AssignmentRepositoryImpl {
	
	@Autowired
	AssignmentRepository assignmentRepository;
	
	public AssignmentEntity saveAssignment(AssignmentEntity assignmentEntity) {
		 return assignmentRepository.save(assignmentEntity);
	}
	
	public List<AssignmentEntity> findAssignmentForTeacher(Long teacherId){
		return assignmentRepository.getByTeacherId(teacherId);
	}

	public List<AssignmentEntity> findAssignmentForStudent(String classId){
		return assignmentRepository.getByClassId(classId);
	}
	
	public AssignmentEntity getAssignmentEntityById(Long assignmentId) {
		return assignmentRepository.getById(assignmentId);
	}
}
