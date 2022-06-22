package com.mpasc.connecttoclass.spring.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Entity
public @Data class FyBscStudentAttendace implements Serializable{
	
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long id;
	private String name;
	private Long roll_num;
	private Long classId;
	private String year;
	
	private String userId;
	private String className;

	private String department;
	private String course;
	private String attendDate;
	private String attendTime;
}
