package com.mpasc.connecttoclass.spring.controller;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mpasc.connecttoclass.spring.entity.AllFaculatyAttendace;
import com.mpasc.connecttoclass.spring.entity.AssignmentEntity;
import com.mpasc.connecttoclass.spring.entity.ClassYear;
import com.mpasc.connecttoclass.spring.entity.FyBscStudentAttendace;
import com.mpasc.connecttoclass.spring.entity.Lecture;
import com.mpasc.connecttoclass.spring.entity.Student;
import com.mpasc.connecttoclass.spring.entity.SyBscStudentAttendace;
import com.mpasc.connecttoclass.spring.entity.Teacher;
import com.mpasc.connecttoclass.spring.entity.TyBscStudentAttendace;
import com.mpasc.connecttoclass.spring.entity.UserEntity;
import com.mpasc.connecttoclass.spring.repository.AllFaculatyAttendaceRepositoryImpl;
import com.mpasc.connecttoclass.spring.repository.AssignmentRepositoryImpl;
import com.mpasc.connecttoclass.spring.repository.FyBscStudentAttendaceRepositoryImpl;
import com.mpasc.connecttoclass.spring.repository.LectureRepositoryImpl;
import com.mpasc.connecttoclass.spring.repository.StudentRepositoryImpl;
import com.mpasc.connecttoclass.spring.repository.SyBscStudentAttendaceRepositoryImpl;
import com.mpasc.connecttoclass.spring.repository.TeacherRepositoryImpl;
import com.mpasc.connecttoclass.spring.repository.TyBscStudentAttendaceRepositoryImpl;
import com.mpasc.connecttoclass.spring.repository.UserRepositoryImpl;

@Controller
@RequestMapping(value="/search-page")
public class SearchController {

	private static final Logger logger = Logger.getLogger(SearchController.class.getName());

	@Autowired
	UserRepositoryImpl userRepo;

	@Autowired
	LectureRepositoryImpl lectureRepo;

	@Autowired
	UserRepositoryImpl UserRepo;

	@Autowired
	StudentRepositoryImpl studentRepo;

	@Autowired
	TeacherRepositoryImpl teacherRepo;

	@Autowired
	AssignmentRepositoryImpl assignmentRepo;

	@Autowired
	SyBscStudentAttendaceRepositoryImpl syAttendaceRepos;

	@Autowired
	FyBscStudentAttendaceRepositoryImpl fyAttendaceRepos;

	@Autowired
	TyBscStudentAttendaceRepositoryImpl tyAttendaceRepos;

	@Autowired
	AllFaculatyAttendaceRepositoryImpl allFaculatyAttendaceRepos;

	@SuppressWarnings("unchecked")
	@GetMapping(value="/all-lectures")
	public ModelAndView searchLectures(HttpServletRequest request,HttpSession session) {
		ModelAndView model= new ModelAndView();
		String userId;
		UserEntity userEntity = new UserEntity();
		Student student= new Student();
		Teacher teacher = new Teacher();
		List<Lecture> lectureList ;
		List<String> headerList = new ArrayList<String>();
		DateTimeFormatter dFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime now = LocalDateTime.now();
		try {
			logger.info("==============inside SearchController.searchLectures");
			model.setViewName("search");
			if(session!=null) {

				if(session.getAttribute("id")!=null&&session.getAttribute("id").equals(session.getId())) {
					session.setAttribute("id", session.getAttribute("id"));

					if(session.getAttribute("user")!=null) {
						model.addObject("username",session.getAttribute("user"));
						session.setAttribute("user", session.getAttribute("user"));  

					}else {
						return model;
					}

					userId=session.getAttribute("userId")!=null?(String) session.getAttribute("userId"):"";
					userEntity=UserRepo.getUser(userId);
					if(userEntity.getDesignation()==0) {
						student=studentRepo.getUser(userId);
						lectureList= lectureRepo.findLecture(student.getClassId().toString());

					}else {
						teacher=teacherRepo.findTeacher(userId);
						lectureList = lectureRepo.findLecture(teacher.getTeacheId());

					}


					model.addObject("object","Lecture");
					headerList.add("Topic");
					headerList.add("Subject");
					headerList.add("Date");
					model.addObject("headerList",headerList);
					model.addObject("lectureList",lectureList);
					model.addObject("userEntity",userEntity);
					model.addObject("total",lectureList.size());

					model.addObject("message",session.getAttribute("message"));
					session.removeAttribute("message");


				}else {
					return model; 
				}
			}else {
				return model;
			} 

		}catch(Exception e) {
			logger.log(Level.SEVERE,"Exception occurs in SearchController.searchLectures  ======>>   ",e);
		}

		return model;
	}


	@SuppressWarnings("unchecked")
	@GetMapping(value="/all-assignments")
	public ModelAndView searchAssignments(HttpServletRequest request,HttpSession session) {

		ModelAndView model= new ModelAndView();
		String userId;
		UserEntity userEntity = new UserEntity();
		Student student= new Student();
		Teacher teacher = new Teacher();
		List<AssignmentEntity> assignmentList ;
		/*DateTimeFormatter dFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");*/
		DateTimeFormatter Formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter dFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime now = LocalDateTime.now();
		try {
			logger.info("==============inside SearchController.searchAssignments");
			model.setViewName("search");
			model.addObject("object","Assignment");

			if(session!=null) {

				if(session.getAttribute("id")!=null&&session.getAttribute("id").equals(session.getId())) {
					session.setAttribute("id", session.getAttribute("id"));

					if(session.getAttribute("user")!=null) {
						model.addObject("username",session.getAttribute("user"));
						session.setAttribute("user", session.getAttribute("user"));  

					}else {
						return model;
					}

					userId=session.getAttribute("userId")!=null?(String) session.getAttribute("userId"):"";
					userEntity=UserRepo.getUser(userId);
					if(userEntity.getDesignation()==0) {
						student=studentRepo.getUser(userId);
						assignmentList= assignmentRepo.findAssignmentForStudent(student.getClassId().toString());

					}else {
						teacher=teacherRepo.findTeacher(userId);
						assignmentList = assignmentRepo.findAssignmentForTeacher(teacher.getTeacheId());

					}
					Collections.sort(assignmentList, new Comparator() {

						@Override
						public int compare(Object o1, Object o2) {
							AssignmentEntity aEntity1 = (AssignmentEntity)o1;
							AssignmentEntity aEntity2 = (AssignmentEntity)o2;
							TemporalAccessor tmp = dFormatter.parse(aEntity1.getAssignStartDate());
							@SuppressWarnings("deprecation")
							Date date= new Date(dFormatter.format(tmp));

							TemporalAccessor tmp2 = dFormatter.parse(aEntity2.getAssignStartDate());
							@SuppressWarnings("deprecation")
							Date date2= new Date(dFormatter.format(tmp));
							return date.compareTo(date2);
						}

					});

					model.addObject("object","Assignment");
					model.addObject("assignmentList",assignmentList);
					model.addObject("userEntity",userEntity);
					model.addObject("total",assignmentList.size());

					model.addObject("message",session.getAttribute("message"));
					session.removeAttribute("message");


				}else {
					return model; 
				}
			}else {
				return model;
			} 

		}catch(Exception e) {
			logger.log(Level.SEVERE,"Exception occurs in SearchController.searchAssignments  ======>>   ",e);
		}

		return model;
	}

	@GetMapping(value="/calendar")
	public String viewCalendarPage( HttpServletRequest request,HttpSession session,Model model) {
		List<SyBscStudentAttendace> syAttendaceList= new ArrayList<>();
		UserEntity userEntity = new UserEntity(); 
		Student student = new Student();
		List<String> attendenceDate= new ArrayList<>();
		List<LocalDate> localDateList= new ArrayList<>();
		List<FyBscStudentAttendace> fyAttendaceList= new ArrayList<>();
		List<TyBscStudentAttendace> tyAttendaceList= new ArrayList<>();
		List<AllFaculatyAttendace> allFaculatyAttList= new ArrayList<>();

		Teacher teacher = new Teacher();
		ClassYear classYear = new ClassYear();
		try {
			session=request.getSession(false);
			if(session!=null) {

				if(session.getAttribute("id")!=null&&session.getAttribute("id").equals(session.getId())) {
					session.setAttribute("id", session.getAttribute("id"));

					if(session.getAttribute("user")!=null) {
						model.addAttribute("username",session.getAttribute("user"));
						session.setAttribute("user", session.getAttribute("user"));  

					}else {
						return "redirect:/"; 
					}
				}else {
					return "redirect:/"; 
				}
			}else {
				return "redirect:/"; 
			}

			model.addAttribute("userId",session.getAttribute("userId"));
			userEntity=userRepo.getUser(session.getAttribute("userId").toString());
			if(userEntity.getDesignation()==0) {
				student=studentRepo.getUser(userEntity.getUserId());
				if(student.getClassId()==1115) {
					fyAttendaceList=fyAttendaceRepos.getAllAttendace(student.getUserId());
					if(fyAttendaceList!=null) {
						for(FyBscStudentAttendace fyBscStudentAtt:fyAttendaceList) {

							DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
							LocalDate localDate= LocalDate.parse(fyBscStudentAtt.getAttendDate(), format);

							localDateList.add(localDate);

							Comparator<LocalDate> comparator = (c1, c2) -> { 
								return (c1).compareTo(c2); 
							};

							Collections.sort(localDateList, comparator);  
						}

					}
					for(LocalDate ldate: localDateList) {
						attendenceDate.add(ldate.toString());

					}

				}else if(student.getClassId()==2115){
					syAttendaceList=syAttendaceRepos.getAllAttendace(student.getUserId());

					if(syAttendaceList!=null) {
						for(SyBscStudentAttendace syBscStudentAtt:syAttendaceList) {
							DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
							LocalDate localDate= LocalDate.parse(syBscStudentAtt.getAttendDate(), format);

							localDateList.add(localDate);

							Comparator<LocalDate> comparator = (c1, c2) -> { 
								return (c1).compareTo(c2); 
							};

							Collections.sort(localDateList, comparator);             


						}


					}
					for(LocalDate ldate: localDateList) {
						attendenceDate.add(ldate.toString());
					}
				}else if(student.getClassId()==3115) {
					tyAttendaceList=tyAttendaceRepos.getAllAttendace(student.getUserId());
					if(tyAttendaceList!=null) {
						for(TyBscStudentAttendace tyBscStudentAtt:tyAttendaceList) {
							DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
							LocalDate localDate= LocalDate.parse(tyBscStudentAtt.getAttendDate(), format);

							localDateList.add(localDate);

							Comparator<LocalDate> comparator = (c1, c2) -> { 
								return (c1).compareTo(c2); 
							};

							Collections.sort(localDateList, comparator);             


						}
					}
					for(LocalDate ldate: localDateList) {
						attendenceDate.add(ldate.toString());

					}

				}

			}else {
				teacher=teacherRepo.findTeacher(userEntity.getUserId());
				allFaculatyAttList=allFaculatyAttendaceRepos.findByUserId(teacher.getUserId());

				if(allFaculatyAttList!=null) {
					for(AllFaculatyAttendace allFaculatyAttendace:allFaculatyAttList) {
						DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
						LocalDate localDate= LocalDate.parse(allFaculatyAttendace.getAttendDate(), format);

						localDateList.add(localDate);

						Comparator<LocalDate> comparator = (c1, c2) -> { 
							return (c1).compareTo(c2); 
						};

						Collections.sort(localDateList, comparator);             


					}
				}

				for(LocalDate ldate: localDateList) {
					attendenceDate.add(ldate.toString());

				}

			}
			System.out.println(attendenceDate);
			model.addAttribute("attendenceDate",attendenceDate);
		}catch(Exception e) {
			logger.log(Level.SEVERE,"Exception occur while creating training  ",e);
			model.addAttribute("errorCode",HttpStatus.INTERNAL_SERVER_ERROR.value());
			model.addAttribute("errorMessage","Oops, something went wrong ");
			return "error";
		}
		return "calendar";
	}

}
