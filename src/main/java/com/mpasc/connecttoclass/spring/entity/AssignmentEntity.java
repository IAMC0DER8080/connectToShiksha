package com.mpasc.connecttoclass.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="Assignment")
public  @Data  class AssignmentEntity {

	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long assignmentId;
	private String subject;
	private Long subjectcode;
	
	private String classId;
	private String className;
	private String assignStartDate;
	private String assignEndDate;
	@Lob
	private byte[] attachment;
	private String teacherNmae;
	private String decription;
	private Long teacherId;
	//private String lectureApp;
	private String topic;
	//private Integer no_of_attendies;
	private String department;
	
}
