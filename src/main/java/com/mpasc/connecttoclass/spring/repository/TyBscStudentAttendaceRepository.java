package com.mpasc.connecttoclass.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.mpasc.connecttoclass.spring.entity.SyBscStudentAttendace;
import com.mpasc.connecttoclass.spring.entity.TyBscStudentAttendace;

@Component
public interface TyBscStudentAttendaceRepository extends JpaRepository<TyBscStudentAttendace, Long>{

	public TyBscStudentAttendace getByUserIdAndAttendDate(String userId, String date);
	
	public List<TyBscStudentAttendace> getByUserId(String userId);
	
}
