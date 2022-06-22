package com.mpasc.connecttoclass.spring.entity;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import lombok.Data;

@Component
@SessionScope
public @Data class UserSession {
	
	private Long id;
	private String username;
	private String userId;
	private String password;
	private String hiidenParameater;
	private int designation;

}
