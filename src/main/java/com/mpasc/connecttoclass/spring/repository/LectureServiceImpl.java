package com.mpasc.connecttoclass.spring.repository;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mpasc.connecttoclass.spring.entity.Lecture;
import com.mpasc.connecttoclass.spring.utility.ApplicationUtil;

@Service
public class LectureServiceImpl implements LectureService{
	
	@Autowired
	LectureRepositoryImpl lectureRepoImpl;

	@Override
	public List<Lecture> findLecture(String classId) {
		// TODO Auto-generated method stub
		List<Lecture> lectureList= lectureRepoImpl.findLecture(classId);
		Iterator iterator = lectureList.listIterator();
        while(iterator.hasNext()) {
        	Lecture lecture=(Lecture) iterator.next();
       //;
		boolean flag=ApplicationUtil.compareDates(lecture.getLecturedate());
		if(!flag) {
			iterator.remove();
		}
        }
		 return lectureList;
	}

	@Override
	public List<Lecture> findLecture(Long teacherId ) {
		// TODO Auto-generated method stub
		 
		List<Lecture> lectureList= lectureRepoImpl.findLecture(teacherId);
				/**/
				Iterator iterator = lectureList.listIterator();
		        while(iterator.hasNext()) {
		        	Lecture lecture=(Lecture) iterator.next();
		       //;
				boolean flag=ApplicationUtil.compareDates(lecture.getLecturedate());
				if(!flag) {
					iterator.remove();
				}
		        }
				 return lectureList;
	}

	@Override
	public Lecture saveLecture(Lecture lecture) {
		// TODO Auto-generated method stub
		return lectureRepoImpl.saveLecture(lecture);
	}

	@Override
	public Lecture getLectureById(Long lectureId) {
		// TODO Auto-generated method stub
		return lectureRepoImpl.getLectureById(lectureId);
	}

}
