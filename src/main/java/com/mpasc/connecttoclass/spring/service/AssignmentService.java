package com.mpasc.connecttoclass.spring.service;

import java.util.List;

import com.mpasc.connecttoclass.spring.entity.AssignmentEntity;

public interface AssignmentService {

	public AssignmentEntity saveAssignment(AssignmentEntity assignmentEntity);
	
	public List<AssignmentEntity> findAssignmentForTeacher(Long teacherId);

	public List<AssignmentEntity> findAssignmentForStudent(String classId);
	
	public AssignmentEntity getAssignmentEntityById(Long assignmentId) ;

}
