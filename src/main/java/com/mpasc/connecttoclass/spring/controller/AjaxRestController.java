package com.mpasc.connecttoclass.spring.controller;


import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mpasc.connecttoclass.spring.entity.AllFaculatyAttendace;
import com.mpasc.connecttoclass.spring.entity.AssignmentEntity;
import com.mpasc.connecttoclass.spring.entity.ClassYear;
import com.mpasc.connecttoclass.spring.entity.FyBscLectureAttendance;
import com.mpasc.connecttoclass.spring.entity.FyBscStudentAttendace;
import com.mpasc.connecttoclass.spring.entity.Lecture;
import com.mpasc.connecttoclass.spring.entity.Student;
import com.mpasc.connecttoclass.spring.entity.SyBscLectureAttendance;
import com.mpasc.connecttoclass.spring.entity.SyBscStudentAttendace;
import com.mpasc.connecttoclass.spring.entity.Teacher;
import com.mpasc.connecttoclass.spring.entity.TyBscLectureAttendance;
import com.mpasc.connecttoclass.spring.entity.TyBscStudentAttendace;
import com.mpasc.connecttoclass.spring.entity.UserEntity;
import com.mpasc.connecttoclass.spring.repository.AllFaculatyAttendaceRepositoryImpl;
import com.mpasc.connecttoclass.spring.repository.ClassYearRepositoryimpl;
import com.mpasc.connecttoclass.spring.repository.FyBscLectureAttRepositoryImpl;
import com.mpasc.connecttoclass.spring.repository.FyBscStudentAttendaceRepositoryImpl;
import com.mpasc.connecttoclass.spring.repository.LectureServiceImpl;
import com.mpasc.connecttoclass.spring.repository.StudentRepositoryImpl;
import com.mpasc.connecttoclass.spring.repository.SubjectRepositoryImpl;
import com.mpasc.connecttoclass.spring.repository.SyBscLectureAttRepositoryImpl;
import com.mpasc.connecttoclass.spring.repository.SyBscStudentAttendaceRepositoryImpl;
import com.mpasc.connecttoclass.spring.repository.TeacherRepositoryImpl;
import com.mpasc.connecttoclass.spring.repository.TyBscLectureAttRepositoryImpl;
import com.mpasc.connecttoclass.spring.repository.TyBscStudentAttendaceRepositoryImpl;
import com.mpasc.connecttoclass.spring.repository.UserRepositoryImpl;
import com.mpasc.connecttoclass.spring.service.AssignmentServiceImpl;
import com.mpasc.connecttoclass.spring.utility.FileUtil;

@RestController
public class AjaxRestController {

	private static final Logger logger = Logger.getLogger(AjaxRestController.class.toString());

	@Autowired
	UserRepositoryImpl userRepo;

	@Autowired
	AssignmentServiceImpl assignmentServiceImpl;

	@Autowired
	StudentRepositoryImpl studentRepo;

	@Autowired
	TeacherRepositoryImpl teacherRepo;

	@Autowired
	ClassYearRepositoryimpl classYearRepo;

	@Autowired
	SubjectRepositoryImpl subjectRepo;

	@Autowired
	FyBscStudentAttendaceRepositoryImpl fyAttendaceRepos;

	@Autowired
	SyBscStudentAttendaceRepositoryImpl syAttendaceRepos;

	@Autowired
	TyBscStudentAttendaceRepositoryImpl tyAttendaceRepos;

	@Autowired
	AllFaculatyAttendaceRepositoryImpl allFaculatyAttendaceRepos;

	@Autowired
	LectureServiceImpl lectureServiceImpl;

	@Autowired
	SyBscLectureAttRepositoryImpl syBscLectureAttRepo;

	@Autowired
	TyBscLectureAttRepositoryImpl tyBscLectureAttRepo;

	@Autowired
	FyBscLectureAttRepositoryImpl fyBscLectureAttRepo;

	@PostMapping(value="/mark-attendance")
	public int markAttendance(@RequestBody String input ){
		Student student = new Student();
		Teacher teacher = new Teacher();
		ClassYear classYear = new ClassYear();
		FyBscStudentAttendace fyAttendace = new FyBscStudentAttendace();
		SyBscStudentAttendace syAttendace = new SyBscStudentAttendace();
		TyBscStudentAttendace tyAttendace= new TyBscStudentAttendace();
		AllFaculatyAttendace allFaculatyAttendace = new AllFaculatyAttendace();
		Date date = new Date(System.currentTimeMillis());  
		SimpleDateFormat dateformatter = new SimpleDateFormat("dd/MM/yyyy");  
		SimpleDateFormat timeformatter = new SimpleDateFormat("hh:mm:ss"); 
		try {
			logger.log(Level.INFO, "Input AjaxRestController.markAttendance()   =====>>  "+input);
			JSONObject jsonObject= new JSONObject(input);



			int dest=(int) jsonObject.get("dest");

			if(dest==0) {
				student=studentRepo.getUser(jsonObject.get("userId").toString());
				classYear=classYearRepo.getByClassid(student.getClassId());
				if(student.getClassId()==1115) {

					fyAttendace.setClassId(student.getClassId());
					fyAttendace.setClassName(classYear.getClassName());
					fyAttendace.setCourse(classYear.getCourse());
					fyAttendace.setDepartment(classYear.getDepartment());
					fyAttendace.setRoll_num(student.getRoll_num());
					fyAttendace.setName(student.getName());
					fyAttendace.setUserId(student.getUserId());
					fyAttendace.setYear(classYear.getYear());
					fyAttendace.setAttendDate(dateformatter.format(date));
					fyAttendace.setAttendTime(timeformatter.format(date));
					fyAttendaceRepos.saveAttendace(fyAttendace);

				}else if(student.getClassId() == 2115) {

					syAttendace.setClassId(student.getClassId());
					syAttendace.setClassName(classYear.getClassName());
					syAttendace.setCourse(classYear.getCourse());
					syAttendace.setDepartment(classYear.getDepartment());
					syAttendace.setRoll_num(student.getRoll_num());
					syAttendace.setName(student.getName());
					syAttendace.setUserId(student.getUserId());
					syAttendace.setYear(classYear.getYear());
					syAttendace.setAttendDate(dateformatter.format(date));
					syAttendace.setAttendTime(timeformatter.format(date));
					syAttendaceRepos.saveAttendace(syAttendace);

				}else if(student.getClassId()==3115) {

					tyAttendace.setClassId(student.getClassId());
					tyAttendace.setClassName(classYear.getClassName());
					tyAttendace.setCourse(classYear.getCourse());
					tyAttendace.setDepartment(classYear.getDepartment());
					tyAttendace.setRoll_num(student.getRoll_num());
					tyAttendace.setName(student.getName());
					tyAttendace.setUserId(student.getUserId());
					tyAttendace.setYear(classYear.getYear());
					tyAttendace.setAttendDate(dateformatter.format(date));
					tyAttendace.setAttendTime(timeformatter.format(date));
					tyAttendaceRepos.saveAttendace(tyAttendace);
				}

			}else {
				teacher=teacherRepo.findTeacher(jsonObject.get("userId").toString());
				allFaculatyAttendace.setDepartment(teacher.getDepartment());
				allFaculatyAttendace.setName(teacher.getName());
				allFaculatyAttendace.setTeacheId(teacher.getTeacheId());
				allFaculatyAttendace.setUserId(teacher.getUserId());
				allFaculatyAttendace.setAttendDate(dateformatter.format(date));
				allFaculatyAttendace.setAttendTime(timeformatter.format(date));
				allFaculatyAttendaceRepos.saveFaculaty(allFaculatyAttendace);
			}

		}catch(Exception e) {
			logger.log(Level.SEVERE, "Exception occured in AjaxRestController.markAttendance()   =====>>  ",e);
			return 0;
		}
		return 1;
	}

	@PostMapping(value="/get-attendance-status")
	public int getAttendanceStatus(@RequestBody String input ){

		Student student = new Student();
		Teacher teacher = new Teacher();
		ClassYear classYear = new ClassYear();
		FyBscStudentAttendace fyAttendace=null;
		SyBscStudentAttendace syAttendace=null ;
		TyBscStudentAttendace tyAttendace=null;
		AllFaculatyAttendace allFaculatyAttendace=null;
		Date date = new Date(System.currentTimeMillis());  
		SimpleDateFormat dateformatter = new SimpleDateFormat("dd/MM/yyyy");  
		try {

			input=input.replace("++", "   ");
			input= input.replace("=", "");

			String[] strArra=input.split(" ");

			if(strArra[strArra.length-1].equals("0")) {
				student=studentRepo.getUser(strArra[0]);

				if(student.getClassId()==1115) {


					fyAttendace=fyAttendaceRepos.findByUserIdAndAttendDate(student.getUserId(), dateformatter.format(date));

					if(fyAttendace!=null) {
						return 1;
					}
				}else if(student.getClassId() == 2115) {


					syAttendace=syAttendaceRepos.findByUserIdAndAttendDate(student.getUserId(), dateformatter.format(date));

					if(syAttendace!=null) {
						return 1;
					}
				}else if(student.getClassId()==3115) {


					tyAttendace=tyAttendaceRepos.findByUserIdAndAttendDate(student.getUserId(), dateformatter.format(date));
					if(tyAttendace!=null) {
						return 1;
					}
				}

			}else {
				teacher=teacherRepo.findTeacher(strArra[0]);
				allFaculatyAttendace=allFaculatyAttendaceRepos.findByUserIdAndAttendDate(teacher.getUserId(), dateformatter.format(date));
				if(allFaculatyAttendace!=null) {
					return 1;
				}
			}



		}catch(Exception e) {
			logger.log(Level.SEVERE, "Exception occured in AjaxRestController.getAttendanceStatus()   =====>>  ",e);
			return 0;
		}

		return 0;
	}



	@PostMapping(value="/get-subject-for-class")
	public String getSubject(@RequestBody String input ){
		JSONObject jsonOutPut =  new JSONObject();
		List<String> subjectList = new ArrayList<String>();
		try {

			JSONObject jsonInput= new JSONObject(input);
			ClassYear classYear=classYearRepo.getByClassName(jsonInput.getString("classYearstr"));
			logger.info("Class object ======>  "+classYear.toString());
			subjectList=subjectRepo.findSubjectNameByClassID(classYear.getClassid());
			logger.info("List of subject  ======>>  "+subjectList);
			int index=0;
			for(String subject : subjectList) {
				jsonOutPut.put(String.valueOf(index), subject);
				index++;
			}

			logger.info("jsonOutPut       ============>>  "+jsonOutPut);
		}catch(Exception e) {
			logger.log(Level.SEVERE, "Exception occured in AjaxRestController.getSubject()   =====>>  ",e);
		}

		return jsonOutPut.toString();

	}

	@GetMapping(value="/get-assignment-file/{id}")
	public ResponseEntity<Object> doenloadFile(@PathVariable String id, HttpServletResponse response ){
		JSONObject jsonOutPut =  new JSONObject();

		ResponseEntity<Object> responseEntity=null; 
		try {
			Charset charset = StandardCharsets.UTF_8;

			AssignmentEntity assignment=assignmentServiceImpl.getAssignmentEntityById(Long.parseLong(id));

			FileUtil fileutil= new FileUtil();
			String path=fileutil.decrypt(assignment.getAttachment());

			File fileFolder = new File(path);

			for (final File fileEntry : fileFolder.listFiles()) {
				String[] nameArr=fileEntry.getName().replace(".",",").split(",");


				if (fileEntry.isFile() && nameArr[0].matches("^[a-zA-Z._-]+$") ) {  

					InputStreamResource resource = new InputStreamResource(new FileInputStream(fileEntry));


					HttpHeaders headers = new HttpHeaders();
					headers.add("Content-Disposition", 
							String.format("attachment; filename=\"%s\"", fileEntry.getName())); 
					headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
					headers.add("Pragma", "no-cache");
					headers.add("Expires", "0");

					responseEntity = ResponseEntity.ok().headers(headers)
							.contentLength(fileEntry.length())
							.contentType(MediaType.parseMediaType("application/txt")).body(resource);


				}

			}

		}catch(Exception e) {
			logger.log(Level.SEVERE, "Exception occured in AjaxRestController.getSubject()   =====>>  ",e);
		}

		return responseEntity;

	}

	@PostMapping(value="/mark-lecture-attendance")
	public String getAttendanceDays(@RequestBody String input ){

		Student student = new Student();


		SyBscLectureAttendance syBscLectureAtt = new SyBscLectureAttendance();
		FyBscLectureAttendance fyBscLectureAtt = new FyBscLectureAttendance();
		TyBscLectureAttendance tyBscLectureAtt = new TyBscLectureAttendance();

		UserEntity userEntity = new UserEntity(); 

		String response="";
		Date date = new Date(System.currentTimeMillis());  
		SimpleDateFormat dateformatter = new SimpleDateFormat("dd/MM/yyyy");  

		try {

			JSONObject jsonInput= new JSONObject(input);
			Lecture lecture=lectureServiceImpl.getLectureById(jsonInput.getLong("lectureId"));
			userEntity=userRepo.getUser(jsonInput.getString("userId"));

			if(lecture.getLecturedate().equals(dateformatter.format(date))) {
				if(userEntity.getDesignation()==0) {
					student=studentRepo.getUser(userEntity.getUserId());

					if(student.getClassId()==1115) {

						if(fyBscLectureAttRepo.findAttendanceMarked(lecture.getLectureId(), userEntity.getUserId())==null) {
							fyBscLectureAtt.setUserId(userEntity.getUserId());
							fyBscLectureAtt.setClassId(student.getClassId());
							fyBscLectureAtt.setLecturedate(lecture.getLecturedate());	
							fyBscLectureAtt.setLectureId(lecture.getLectureId());
							fyBscLectureAtt.setDepartment(lecture.getDepartment());
							fyBscLectureAtt.setLecturetime(lecture.getLecturetime());
							fyBscLectureAtt.setRoll_num(student.getRoll_num());
							fyBscLectureAtt.setStudentName(student.getName());
							fyBscLectureAtt.setSubject(lecture.getSubject());
							fyBscLectureAtt.setSubjectcode(lecture.getSubjectcode());
							fyBscLectureAtt.setTeacherId(lecture.getTeacherId());
							fyBscLectureAtt.setTeacherNmae(lecture.getTeacherNmae());
							fyBscLectureAtt.setTopic(lecture.getTopic());

							fyBscLectureAttRepo.saveAttendace(fyBscLectureAtt);
							response="00";
						}else {
							response="02";
						}

					}else if(student.getClassId() == 2115) {

						if(syBscLectureAttRepo.findAttendanceMarked(lecture.getLectureId(), userEntity.getUserId())==null) {
							syBscLectureAtt.setUserId(userEntity.getUserId());
							syBscLectureAtt.setClassId(student.getClassId());
							syBscLectureAtt.setLecturedate(lecture.getLecturedate());	
							syBscLectureAtt.setLectureId(lecture.getLectureId());
							syBscLectureAtt.setDepartment(lecture.getDepartment());
							syBscLectureAtt.setLecturetime(lecture.getLecturetime());
							syBscLectureAtt.setRoll_num(student.getRoll_num());
							syBscLectureAtt.setStudentName(student.getName());
							syBscLectureAtt.setSubject(lecture.getSubject());
							syBscLectureAtt.setSubjectcode(lecture.getSubjectcode());
							syBscLectureAtt.setTeacherId(lecture.getTeacherId());
							syBscLectureAtt.setTeacherNmae(lecture.getTeacherNmae());
							syBscLectureAtt.setTopic(lecture.getTopic());

							syBscLectureAttRepo.saveAttendace(syBscLectureAtt);
							response="00";
						}else {
							response="02";
						}

					}else if(student.getClassId()==3115) {

						if(tyBscLectureAttRepo.findAttendanceMarked(lecture.getLectureId(), userEntity.getUserId())==null) {
							tyBscLectureAtt.setUserId(userEntity.getUserId());
							tyBscLectureAtt.setClassId(student.getClassId());
							tyBscLectureAtt.setLecturedate(lecture.getLecturedate());	
							tyBscLectureAtt.setLectureId(lecture.getLectureId());
							tyBscLectureAtt.setDepartment(lecture.getDepartment());
							tyBscLectureAtt.setLecturetime(lecture.getLecturetime());
							tyBscLectureAtt.setRoll_num(student.getRoll_num());
							tyBscLectureAtt.setStudentName(student.getName());
							tyBscLectureAtt.setSubject(lecture.getSubject());
							tyBscLectureAtt.setSubjectcode(lecture.getSubjectcode());
							tyBscLectureAtt.setTeacherId(lecture.getTeacherId());
							tyBscLectureAtt.setTeacherNmae(lecture.getTeacherNmae());
							tyBscLectureAtt.setTopic(lecture.getTopic());
							tyBscLectureAttRepo.saveAttendace(tyBscLectureAtt);
							response="00";
						}else {
							response="02";
						}
					}


				}
			}else {
				response="01";
			}


		}catch(Exception e) {
			logger.log(Level.SEVERE, "Exception occured in AjaxRestController.getAttendanceDays()   =====>>  ",e);
			response="99";
		}

		return response;
	}

	@GetMapping(value="/view-assignment/{id}/{rollNum}")
	public ResponseEntity<Object> doenloadFile(@PathVariable String id, @PathVariable String rollNum, HttpServletResponse response ){
		ResponseEntity<Object> responseEntity=null; 
		try {
			AssignmentEntity assignment=assignmentServiceImpl.getAssignmentEntityById(Long.parseLong(id));

			FileUtil fileutil= new FileUtil();
			String path=fileutil.decrypt(assignment.getAttachment());

			File fileFolder = new File(path);

			for (final File fileEntry : fileFolder.listFiles()) {

				String[] nameArr=fileEntry.getName().replace(".",",").split(",");

				if (fileEntry.isFile() && nameArr[0].equalsIgnoreCase(rollNum) ) { 

					InputStreamResource resource = new InputStreamResource(new FileInputStream(fileEntry));
					HttpHeaders headers = new HttpHeaders();
					headers.add("Content-Disposition", 
							String.format("attachment; filename=\"%s\"", fileEntry.getName())); 
					headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
					headers.add("Pragma", "no-cache");
					headers.add("Expires", "0");

					responseEntity = ResponseEntity.ok().headers(headers)
							.contentLength(fileEntry.length())
							.contentType(MediaType.parseMediaType("application/txt")).body(resource);
				}
			}

		}catch(Exception e) {
			logger.log(Level.SEVERE, "Exception occured in AjaxRestController.doenloadFile()   =====>>  ",e);
		}
		return responseEntity;
	}


}
