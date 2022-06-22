package com.mpasc.connecttoclass.spring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpasc.connecttoclass.spring.entity.TyBscLectureAttendance;

@Service
public class TyBscLectureAttRepositoryImpl {
	
	@Autowired
	TyBscLectureAttRepository tyBscLectureAttRepo;
	
	public void saveAttendace(TyBscLectureAttendance tyAttendace) {

		tyBscLectureAttRepo.save(tyAttendace);
	}
	
	public TyBscLectureAttendance findAttendanceMarked(Long lectureId,String userId) {

		return tyBscLectureAttRepo.getByLectureIdAndUserId(lectureId, userId);
	}
	
	public List<TyBscLectureAttendance> findAttendance(Long lectureId) {

		return tyBscLectureAttRepo.getByLectureId(lectureId);
	}

}
