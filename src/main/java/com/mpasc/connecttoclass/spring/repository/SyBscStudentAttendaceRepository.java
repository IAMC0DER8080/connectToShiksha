package com.mpasc.connecttoclass.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.mpasc.connecttoclass.spring.entity.AllFaculatyAttendace;
import com.mpasc.connecttoclass.spring.entity.FyBscStudentAttendace;
import com.mpasc.connecttoclass.spring.entity.SyBscStudentAttendace;

@Component
public interface SyBscStudentAttendaceRepository extends JpaRepository<SyBscStudentAttendace, Long>{
	
	public SyBscStudentAttendace getByUserIdAndAttendDate(String userId, String date) ;
	public List<SyBscStudentAttendace>  getByUserId(String userId);

}
