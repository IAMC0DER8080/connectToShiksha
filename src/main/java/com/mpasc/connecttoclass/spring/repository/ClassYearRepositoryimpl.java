package com.mpasc.connecttoclass.spring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpasc.connecttoclass.spring.entity.ClassYear;

@Service
public class ClassYearRepositoryimpl {

	@Autowired
	ClassYearRepository classYearRepo;
	
	public List<ClassYear> findAll(){
		return classYearRepo.findAll();
	}
	
	public ClassYear getByClassName(String ClassName) {
		return classYearRepo.getByClassName(ClassName);
	}
	
	public ClassYear getByClassid(Long classId) {
		return classYearRepo.getByClassid(classId.toString());
	}
}
