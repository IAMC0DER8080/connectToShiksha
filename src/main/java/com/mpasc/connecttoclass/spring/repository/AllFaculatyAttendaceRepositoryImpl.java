package com.mpasc.connecttoclass.spring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpasc.connecttoclass.spring.entity.AllFaculatyAttendace;

@Service
public class AllFaculatyAttendaceRepositoryImpl {
	
	@Autowired
	AllFaculatyAttendaceRepository allFaculatyAttendaceRepos;
	
	public void saveFaculaty(AllFaculatyAttendace allFaculatyAttendace) {
		allFaculatyAttendaceRepos.save(allFaculatyAttendace);
	}
	
	public AllFaculatyAttendace findByUserIdAndAttendDate(String userId, String date) {
		return allFaculatyAttendaceRepos.getByUserIdAndAttendDate(userId, date);
	}
	
	public List<AllFaculatyAttendace> findByUserId(String userId) {
		return allFaculatyAttendaceRepos.getByUserId(userId);
	}

}
