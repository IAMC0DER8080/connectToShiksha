package com.mpasc.connecttoclass.spring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpasc.connecttoclass.spring.entity.Subject;

@Service
public class SubjectRepositoryImpl {

	@Autowired
	SubjectRepository subjectRepo;
	
	public Subject findSubjectcode(String name) {
		return subjectRepo.findSubjectcodeByName(name);
	}
	
	public List<String> findSubjectNameByClassID(String classId){
		return subjectRepo.getNameByClassId(classId);
		
	}
	
}
