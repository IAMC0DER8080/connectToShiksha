package com.mpasc.connecttoclass.spring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpasc.connecttoclass.spring.entity.FyBscLectureAttendance;

@Service
public class FyBscLectureAttRepositoryImpl {
	
	@Autowired
	FyBscLectureAttRepository fyBscLectureAttRepo;
	
	public void saveAttendace(FyBscLectureAttendance fyAttendace) {

		fyBscLectureAttRepo.save(fyAttendace);
	}
	
	public FyBscLectureAttendance findAttendanceMarked(Long lectureId,String userId) {

		return fyBscLectureAttRepo.getByLectureIdAndUserId(lectureId, userId);
	}
	
	public List<FyBscLectureAttendance> findAttendance(Long lectureId) {

		return fyBscLectureAttRepo.getByLectureId(lectureId);
	}

}
