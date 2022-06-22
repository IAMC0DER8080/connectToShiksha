package com.mpasc.connecttoclass.spring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpasc.connecttoclass.spring.entity.ClassYear;
import com.mpasc.connecttoclass.spring.entity.FyBscStudentAttendace;
import com.mpasc.connecttoclass.spring.entity.Student;

@Service
public class FyBscStudentAttendaceRepositoryImpl {

	@Autowired
	FyBscStudentAttendaceRepository fyBscAttendaceRepo;

	public void saveAttendace(FyBscStudentAttendace fyBscStudentAttendace) {

		fyBscAttendaceRepo.save(fyBscStudentAttendace);
	}

	public FyBscStudentAttendace findByRoll_num(Long roll_num) {
		return fyBscAttendaceRepo.findByRoll_num(roll_num);
	}

	public FyBscStudentAttendace findByUserIdAndAttendDate(String userId,String AttendDate) {

		return fyBscAttendaceRepo.getByUserIdAndAttendDate(userId,AttendDate);
	}

	public List<FyBscStudentAttendace> getAllAttendace(String userId) {

		return fyBscAttendaceRepo.getByUserId(userId);
	}



}
