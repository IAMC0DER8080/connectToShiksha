package com.mpasc.connecttoclass.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Entity
public @Data class TyBscLectureAttendance implements Serializable{
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long Id;
	private Long lectureId;
	private String userId;
	private String studentName;
	private Long roll_num;
	private Long teacherId;
	private String teacherNmae;
	private String subject;
	private Long subjectcode;
	
	private Long classId;
	private String lecturedate;
	private String lecturetime;
	
	
	private String topic;
	private String department;

}
