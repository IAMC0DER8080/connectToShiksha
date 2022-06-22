package com.mpasc.connecttoclass.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.mpasc.connecttoclass.spring.entity.TyBscLectureAttendance;

@Component
public interface TyBscLectureAttRepository extends JpaRepository<TyBscLectureAttendance, Long>{
	
	public TyBscLectureAttendance getByLectureIdAndUserId(Long lectureId,String userId);
	
	
	public List<TyBscLectureAttendance> getByLectureId(Long lectureId);

}
