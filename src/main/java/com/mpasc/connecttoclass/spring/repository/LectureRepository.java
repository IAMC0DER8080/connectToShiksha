package com.mpasc.connecttoclass.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.mpasc.connecttoclass.spring.entity.Lecture;

@Component
public interface LectureRepository extends JpaRepository<Lecture, Long>{
	
	List<Lecture> getLectureByClassId(String classId);
	
	List<Lecture> getLectureByTeacherId(Long teacherId);
}
