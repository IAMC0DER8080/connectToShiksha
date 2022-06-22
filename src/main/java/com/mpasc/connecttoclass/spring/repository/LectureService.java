package com.mpasc.connecttoclass.spring.repository;

import java.util.List;

import com.mpasc.connecttoclass.spring.entity.Lecture;

public interface LectureService {

	List<Lecture> findLecture(String classId);

	List<Lecture> findLecture(Long teacherId);

	public Lecture saveLecture(Lecture lecture);
	
	public Lecture getLectureById(Long lectureId);

}
