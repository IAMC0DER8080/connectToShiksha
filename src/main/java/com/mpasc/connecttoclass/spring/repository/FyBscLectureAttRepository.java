package com.mpasc.connecttoclass.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.mpasc.connecttoclass.spring.entity.FyBscLectureAttendance;
@Component
public interface FyBscLectureAttRepository extends JpaRepository<FyBscLectureAttendance, Long>{

	public FyBscLectureAttendance getByLectureIdAndUserId(Long lectureId,String userId);
	
	public List<FyBscLectureAttendance> getByLectureId(Long lectureId);
	
}
