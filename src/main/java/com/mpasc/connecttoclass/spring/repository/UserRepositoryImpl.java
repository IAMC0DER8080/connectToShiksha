package com.mpasc.connecttoclass.spring.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpasc.connecttoclass.spring.entity.UserEntity;

@Service
public class UserRepositoryImpl {
	
	@Autowired
	UserRepository userRepo;
	
	public UserEntity getUser(String userId) {
		return userRepo.findByUserId(userId);
	}

}
