package com.mpasc.connecttoclass.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.mpasc.connecttoclass.spring.entity.AllFaculatyAttendace;

@Component
public interface AllFaculatyAttendaceRepository extends JpaRepository<AllFaculatyAttendace, Long>{
	
	public AllFaculatyAttendace getByUserIdAndAttendDate(String userId, String date) ;
	
	public List<AllFaculatyAttendace> getByUserId(String userId);
	
}
