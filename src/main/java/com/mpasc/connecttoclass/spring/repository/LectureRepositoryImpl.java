package com.mpasc.connecttoclass.spring.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpasc.connecttoclass.spring.entity.Lecture;
import com.mpasc.connecttoclass.spring.utility.ApplicationUtil;

@Service
public class LectureRepositoryImpl {

	@Autowired
	LectureRepository lectureRepo;
	
	
	
	public List<Lecture> findLecture(String classId){
		
		return lectureRepo.getLectureByClassId(classId);
		
	}
	
	public List<Lecture> findLecture(Long teacherId){
		return lectureRepo.getLectureByTeacherId(teacherId);
		
	}
	
	public Lecture saveLecture(Lecture lecture) {
		return lectureRepo.save(lecture);
	}
	
	public Lecture getLectureById(Long lectureId) {
		return lectureRepo.getById(lectureId);
	}
	
	
	
	  
	
}
