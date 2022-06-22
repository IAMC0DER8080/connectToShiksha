package com.mpasc.connecttoclass.spring.entity;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Component
public @Data class AssignmentModel {

	

	//private Long lectureId;
	private Long assignmentId;
	private String subject;
	private Long subjectcode;
	
	private String classId;
	private String className;
	private String assignStartDate;
	private String assignEndDate;
	
	private MultipartFile attachment;
	private String teacherNmae;
	private String decription;
	private Long teacherId;
	//private String lectureApp;
	private String topic;
	//private Integer no_of_attendies;
	private String department;
	
	
}
