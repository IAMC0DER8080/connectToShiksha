package com.mpasc.connecttoclass.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.mpasc.connecttoclass.spring.entity.UserEntity;

@Component
public interface UserRepository extends JpaRepository<UserEntity, String>{

	UserEntity findByUserId(String userId);

}
