package com.mpasc.connecttoclass.spring.controller;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mpasc.connecttoclass.spring.entity.AssignmentEntity;
import com.mpasc.connecttoclass.spring.entity.AssignmentModel;
import com.mpasc.connecttoclass.spring.entity.ClassYear;
import com.mpasc.connecttoclass.spring.entity.Lecture;
import com.mpasc.connecttoclass.spring.entity.Student;
import com.mpasc.connecttoclass.spring.entity.Subject;
import com.mpasc.connecttoclass.spring.entity.Teacher;
import com.mpasc.connecttoclass.spring.entity.UserEntity;
import com.mpasc.connecttoclass.spring.entity.UserSession;
import com.mpasc.connecttoclass.spring.repository.AssignmentRepositoryImpl;
import com.mpasc.connecttoclass.spring.repository.ClassYearRepositoryimpl;
import com.mpasc.connecttoclass.spring.repository.LectureServiceImpl;
import com.mpasc.connecttoclass.spring.repository.StudentRepositoryImpl;
import com.mpasc.connecttoclass.spring.repository.SubjectRepositoryImpl;
import com.mpasc.connecttoclass.spring.repository.TeacherRepositoryImpl;
import com.mpasc.connecttoclass.spring.repository.UserRepositoryImpl;
import com.mpasc.connecttoclass.spring.service.AssignmentServiceImpl;
import com.mpasc.connecttoclass.spring.utility.FileUtil;

@Controller
public class ProcessController {

	private static final Logger logger= Logger.getLogger(ProcessController.class.getName());



	@Autowired
	LectureServiceImpl lectureServiceImpl;

	@Autowired
	AssignmentServiceImpl assignService;

	@Autowired
	UserRepositoryImpl UserRepo;

	@Autowired
	StudentRepositoryImpl studentRepo;

	@Autowired
	TeacherRepositoryImpl teacherRepo;

	@Autowired
	ClassYearRepositoryimpl classYearRepo;

	@Autowired
	SubjectRepositoryImpl subjectRepo;

	@Autowired
	FileUtil fileUtil;

	@Autowired
	AssignmentRepositoryImpl assignmentRepositoryImpl;

	@Autowired
	UserSession userSession;

	@GetMapping(value = "/dashboard")
	public String dashboard(HttpServletRequest request,HttpSession session,Model model) {
		Integer count=0;
		HashMap<String,Integer> uatMap = new HashMap<>();
		HashMap<String,Integer> ProdMap = new HashMap<>();
		//String userId;
		UserEntity userEntity = new UserEntity();
		Student student= new Student();
		Teacher teacher = new Teacher();
		List<Lecture> lectureList ;
		List<AssignmentEntity> assignmentList = null ;
		DateTimeFormatter dFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter tFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalDate dateObj = LocalDate.now();
		//LocalDateTime now = LocalDateTime.now();
		String date;
		try {

			if(userSession.getDesignation()==0) {
				student=studentRepo.getUser(String.valueOf(userSession.getUserId())  );  // userId
				lectureList= lectureServiceImpl.findLecture(student.getClassId().toString() );
				logger.log(Level.INFO,"lectureList for student =======> "+lectureList);
				assignmentList=assignService.findAssignmentForStudent(student.getClassId().toString());
			}else {
				teacher=teacherRepo.findTeacher(String.valueOf(userSession.getUserId()));  // userId
				lectureList = lectureServiceImpl.findLecture(teacher.getTeacheId());
				logger.log(Level.INFO,"lectureList for teacher =======> "+lectureList);

				date = dateObj.format(dFormatter);
				assignmentList=assignService.findAssignmentForTeacher(teacher.getTeacheId());
				logger.log(Level.INFO,"assignmentList for teacher =======> "+assignmentList);
			}
			model.addAttribute("assignmentList",assignmentList);
			model.addAttribute("lectureList",lectureList);
			model.addAttribute("userEntity",userSession);
			model.addAttribute("username",userSession.getUsername());

			model.addAttribute("message",session.getAttribute("message"));
			session.removeAttribute("message");


		}catch(Exception e) {
			logger.log(Level.SEVERE,"Exception occur while fetching the data dashboard   ",e);
			model.addAttribute("errorCode",HttpStatus.INTERNAL_SERVER_ERROR.value());
			model.addAttribute("errorMessage","Oops, something went wrong ");
			return "error";
		}
		return "dashboard";
	}


	@GetMapping(value="/create-new-training")
	public String createNewLecture(HttpServletRequest request,HttpSession session,Model model) {

		List<ClassYear> classYearList= new ArrayList<ClassYear>();
		List<String>classList = new ArrayList<String>();
		List<String>deptList = new ArrayList<String>();
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
			classYearList=classYearRepo.findAll();
			for(ClassYear classYear : classYearList) {
				classList.add(classYear.getClassName());
				deptList.add(classYear.getDepartment());
			}
			model.addAttribute("Lecture", new Lecture());
			model.addAttribute("classList", classList);
			model.addAttribute("deptList", deptList);

		}catch(Exception e) {
			logger.log(Level.SEVERE,"Exception occur while creating training  ",e);
			model.addAttribute("errorCode",HttpStatus.INTERNAL_SERVER_ERROR.value());
			model.addAttribute("errorMessage","Oops, something went wrong ");
			return "error";
		}
		return "create-new-training";
	}

	@GetMapping(value="/create-new-assignment")
	public String createNewAssignment(HttpServletRequest request,HttpSession session,Model model) {

		List<ClassYear> classYearList= new ArrayList<ClassYear>();
		Set<String>classList = new HashSet<String>();
		Set<String>deptList = new HashSet<String>();
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
			classYearList=classYearRepo.findAll();
			for(ClassYear classYear : classYearList) {
				classList.add(classYear.getClassName());
				deptList.add(classYear.getDepartment());
			}
			model.addAttribute("Assignment", new AssignmentModel());
			model.addAttribute("classList", classList);
			model.addAttribute("deptList", deptList);

		}catch(Exception e) {
			logger.log(Level.SEVERE,"Exception occur while create new Assignment  ",e);
			model.addAttribute("errorCode",HttpStatus.INTERNAL_SERVER_ERROR.value());
			model.addAttribute("errorMessage","Oops, something went wrong ");
			return "error";
		}
		return "create-new-assignments";
	}

	@PostMapping(value="lecture-save")
	public String saveNewLecture(@ModelAttribute("Lecture")Lecture lecture,HttpServletRequest request,HttpSession session,Model model) {
		Teacher teacher = new Teacher();
		ClassYear classYear = new ClassYear();
		Subject subject = new Subject();

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
			classYear=classYearRepo.getByClassName(lecture.getClassName());
			lecture.setClassId(classYear.getClassid());

			subject=subjectRepo.findSubjectcode(lecture.getSubject());

			lecture.setSubjectcode(subject.getSubjectcode());

			teacher=teacherRepo.findTeacher(session.getAttribute("userId").toString());
			lecture.setTeacherNmae(teacher.getName());
			lecture.setTeacherId(teacher.getTeacheId());
			Date date1=new SimpleDateFormat("MM/dd/yyyy").parse(lecture.getLecturedate());  


			lecture.setLecturedate(new SimpleDateFormat("dd/MM/yyyy").format(date1)) ;


			lectureServiceImpl.saveLecture(lecture);
			return "redirect:./dashboard";
		}catch(Exception e) {
			logger.log(Level.SEVERE,"Exception occur while save new Lecture  ",e);
			model.addAttribute("errorMessage","Oops, something went wrong ");
			//return "error";
			return "create-new-training";
		}
	}

	@PostMapping(value="assignment-save")
	public String saveNewAssignment(@ModelAttribute("Assignment")AssignmentModel assignment,HttpServletRequest request,HttpSession session,Model model) {
		Teacher teacher = new Teacher();
		ClassYear classYear = new ClassYear();
		Subject subject = new Subject();
		Date date1;
		AssignmentEntity assignmentEntity = new AssignmentEntity();

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
			classYear=classYearRepo.getByClassName(assignment.getClassName());
			assignmentEntity.setClassId(classYear.getClassid());

			subject=subjectRepo.findSubjectcode(assignment.getSubject());

			assignmentEntity.setSubjectcode(subject.getSubjectcode());
			//session.getAttribute("userId");
			teacher=teacherRepo.findTeacher(session.getAttribute("userId").toString());

			assignmentEntity.setTeacherNmae(teacher.getName());
			assignmentEntity.setTeacherId(teacher.getTeacheId());
			date1=new SimpleDateFormat("MM/dd/yyyy").parse(assignment.getAssignStartDate());  

			assignmentEntity.setAssignStartDate(new SimpleDateFormat("dd/MM/yyyy").format(date1)) ;
			date1=new SimpleDateFormat("MM/dd/yyyy").parse(assignment.getAssignEndDate()); 

			assignmentEntity.setAssignEndDate(new SimpleDateFormat("dd/MM/yyyy").format(date1)) ;
			assignmentEntity.setSubject(assignment.getSubject());
			assignmentEntity.setTopic(assignment.getTopic());
			assignmentEntity.setDecription(assignment.getDecription());
			assignmentEntity.setDepartment(assignment.getDepartment());
			assignmentEntity.setClassName(assignment.getClassName());

			String filewriteResponse=fileUtil.write(assignment.getAttachment());

			if(!filewriteResponse.equalsIgnoreCase("Failed")) {
				byte[] pathArray=fileUtil.encrypt(filewriteResponse);  

				assignmentEntity.setAttachment(pathArray); 
			}
			assignmentRepositoryImpl.saveAssignment(assignmentEntity);
			return "redirect:./dashboard";
		}catch(Exception e) {
			logger.log(Level.SEVERE,"Exception occur while save new Assignment  ",e);

			model.addAttribute("errorMessage","Oops, something went wrong ");
			return "create-new-training";
		}
	}

	@PostMapping(value="assignment-submit")
	public String submitNewAssignment(@ModelAttribute("Assignment")AssignmentModel assignment,HttpServletRequest request,HttpSession session,Model model) {
		Teacher teacher = new Teacher();
		UserEntity userEntity = new UserEntity();
		ClassYear classYear = new ClassYear();
		Subject subject = new Subject();
		Student student= new Student();
		Date date1;
		AssignmentEntity assignmentEntity = new AssignmentEntity();
		String userId=null;

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
			userId=session.getAttribute("userId")!=null?(String) session.getAttribute("userId"):"";
			session.setAttribute("userId", userId);

			userEntity=UserRepo.getUser(userId);
			if(userEntity.getDesignation()==0) {
				student=studentRepo.getUser(userId);
				assignmentEntity=assignmentRepositoryImpl.getAssignmentEntityById(assignment.getAssignmentId());
				String path=fileUtil.decrypt(assignmentEntity.getAttachment());
				String filewriteResponse=fileUtil.writeSubFile(path,student.getRoll_num(),assignment.getAttachment());


			}
			return "redirect:./dashboard";
		}catch(Exception e) {
			logger.log(Level.SEVERE,"Exception occur while submit new Assignment  ",e);
			model.addAttribute("errorMessage","Oops, something went wrong ");
			//return "error";
			return "create-new-training";
		}
	}

}
