package com.mpasc.connecttoclass.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.mpasc.connecttoclass.spring.entity.FyBscStudentAttendace;

@Component
public interface FyBscStudentAttendaceRepository extends JpaRepository<FyBscStudentAttendace, Long>{

	
	public FyBscStudentAttendace findByRoll_num(Long roll_num);
	public FyBscStudentAttendace getByUserIdAndAttendDate(String userId,String attendDate);
	public List<FyBscStudentAttendace>  getByUserId(String userId);
}
