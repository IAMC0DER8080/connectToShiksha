package com.mpasc.connecttoclass.spring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpasc.connecttoclass.spring.entity.SyBscStudentAttendace;

@Service
public class SyBscStudentAttendaceRepositoryImpl {

	@Autowired
	SyBscStudentAttendaceRepository syAttendaceRepo;

	public void saveAttendace(SyBscStudentAttendace syAttendace) {

		syAttendaceRepo.save(syAttendace);
	}

	public SyBscStudentAttendace findByUserIdAndAttendDate(String userId, String date) {
		return syAttendaceRepo.getByUserIdAndAttendDate(userId, date);
	}
	
	public List<SyBscStudentAttendace> getAllAttendace(String userId) {
		return syAttendaceRepo.getByUserId(userId);
	}

}
