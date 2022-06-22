package com.mpasc.connecttoclass.spring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpasc.connecttoclass.spring.entity.SyBscLectureAttendance;

@Service
public class SyBscLectureAttRepositoryImpl {
	
	@Autowired
	SyBscLectureAttRepository syBscLectureAttRepo;
	
	public void saveAttendace(SyBscLectureAttendance syAttendace) {

		syBscLectureAttRepo.save(syAttendace);
	}
	
	public SyBscLectureAttendance findAttendanceMarked(Long lectureId,String userId) {

		return syBscLectureAttRepo.getByLectureIdAndUserId(lectureId, userId);
	}
	
	public List<SyBscLectureAttendance> findAttendance(Long lectureId) {

		return syBscLectureAttRepo.getByLectureId(lectureId);
	}

}
