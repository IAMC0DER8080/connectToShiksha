package com.mpasc.connecttoclass.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
public @Data class AllFaculatyAttendace implements Serializable{
	
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long id;
	private String name;
	private String userId;
	private Long teacheId;
	private String department;
	private String attendDate;
	private String attendTime;

}
