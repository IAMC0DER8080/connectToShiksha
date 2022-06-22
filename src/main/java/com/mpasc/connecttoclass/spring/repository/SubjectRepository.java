package com.mpasc.connecttoclass.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.mpasc.connecttoclass.spring.entity.Subject;
@Component
public interface SubjectRepository extends JpaRepository<Subject, String>{
			
	public Subject findSubjectcodeByName(String name);
	
	@Query("select name from Subject where classId = :classId")
	public List<String> getNameByClassId(String classId);
	
}
