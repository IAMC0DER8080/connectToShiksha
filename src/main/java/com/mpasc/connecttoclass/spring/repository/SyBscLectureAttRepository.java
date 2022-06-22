package com.mpasc.connecttoclass.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.mpasc.connecttoclass.spring.entity.SyBscLectureAttendance;

@Component
public interface SyBscLectureAttRepository extends JpaRepository<SyBscLectureAttendance, Long>{
	
	public SyBscLectureAttendance getByLectureIdAndUserId(Long lectureId,String userId);
	
	public List<SyBscLectureAttendance> getByLectureId(Long lectureId);

}
