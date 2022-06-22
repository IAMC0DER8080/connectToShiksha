package com.mpasc.connecttoclass.spring.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mpasc.connecttoclass.spring.entity.AssignmentEntity;

public interface AssignmentRepository extends JpaRepository<AssignmentEntity, Long>{

	List<AssignmentEntity> getByTeacherId(Long teacherId);
	
	List<AssignmentEntity> getByClassId(String classId);
	
}
