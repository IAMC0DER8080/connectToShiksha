package com.mpasc.connecttoclass.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.web.context.annotation.SessionScope;

import lombok.Data;

@Entity
public @Data class UserEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long id;
	private String username;
	private String userId;
	private String password;
	private String hiidenParameater;
	private int designation;

	
	
	

}
