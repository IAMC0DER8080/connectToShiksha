package com.mpasc.connecttoclass.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.mpasc.connecttoclass.spring.entity.ClassYear;

@Component
public interface ClassYearRepository extends JpaRepository<ClassYear, String>{
		
			public ClassYear getByClassName(String ClassName);
			
			public ClassYear getByClassid(String classId);
}
