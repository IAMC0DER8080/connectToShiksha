package com.mpasc.connecttoclass.spring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpasc.connecttoclass.spring.entity.SyBscStudentAttendace;
import com.mpasc.connecttoclass.spring.entity.TyBscStudentAttendace;
@Service
public class TyBscStudentAttendaceRepositoryImpl {
	
	@Autowired
	TyBscStudentAttendaceRepository TyAttendaceRepos;
	
	public void saveAttendace(TyBscStudentAttendace TyAttendace) {

		TyAttendaceRepos.save(TyAttendace);
	}
	
	public TyBscStudentAttendace findByUserIdAndAttendDate(String userId, String date) {
		return TyAttendaceRepos.getByUserIdAndAttendDate(userId,date);
	}
	
	public List<TyBscStudentAttendace> getAllAttendace(String userId) {
		return TyAttendaceRepos.getByUserId(userId);
	}

}
