package com.mpasc.connecttoclass.spring.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpasc.connecttoclass.spring.entity.AssignmentEntity;
import com.mpasc.connecttoclass.spring.entity.Lecture;
import com.mpasc.connecttoclass.spring.repository.AssignmentRepositoryImpl;
import com.mpasc.connecttoclass.spring.utility.ApplicationUtil;


@Service
public class AssignmentServiceImpl implements AssignmentService{
	
@Autowired
AssignmentRepositoryImpl assignmentRepoImpl;
	
	@Override
	public AssignmentEntity saveAssignment(AssignmentEntity assignmentEntity) {
		// TODO Auto-generated method stub
		return assignmentRepoImpl.saveAssignment(assignmentEntity);
	}

	@Override
	public List<AssignmentEntity> findAssignmentForTeacher(Long teacherId) {
		// TODO Auto-generated method stub
		 
		List<AssignmentEntity> assignmentList= assignmentRepoImpl.findAssignmentForTeacher(teacherId);
		Iterator iterator = assignmentList.listIterator();
		while(iterator.hasNext()) {
        	AssignmentEntity assignmentEntity=(AssignmentEntity) iterator.next();
       //;
		boolean flag=ApplicationUtil.compareDates(assignmentEntity.getAssignEndDate());
		if(!flag) {
			iterator.remove();
		}
        }
		 return assignmentList;
	}

	@Override
	public List<AssignmentEntity> findAssignmentForStudent(String classId) {
		// TODO Auto-generated method stub
		 
		List<AssignmentEntity> assignmentList= assignmentRepoImpl.findAssignmentForStudent(classId);
		Iterator iterator = assignmentList.listIterator();
        while(iterator.hasNext()) {
        	AssignmentEntity assignmentEntity=(AssignmentEntity) iterator.next();
       //;
		boolean flag=ApplicationUtil.compareDates(assignmentEntity.getAssignEndDate());
		if(!flag) {
			iterator.remove();
		}
        }
		 return assignmentList;
	}

	@Override
	public AssignmentEntity getAssignmentEntityById(Long assignmentId) {
		// TODO Auto-generated method stub
		return assignmentRepoImpl.getAssignmentEntityById(assignmentId);
	}

}
