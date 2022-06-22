package com.mpasc.connecttoclass.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
public @Data class Lecture implements Serializable{
	
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long lectureId;
	private String subject;
	private Long subjectcode;
	
	private String classId;
	private String className;
	private String lecturedate;
	private String lecturetime;
	private String URL;
	private String teacherNmae;
	private String decription;
	private Long teacherId;
	private String lectureApp;
	private String topic;
	private Integer no_of_attendies;
	private String department;
	

}
