package com.mpasc.connecttoclass.spring.controller;

import java.io.File;
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
import org.springframework.web.bind.annotation.PathVariable;

import com.mpasc.connecttoclass.spring.entity.AssignmentEntity;
import com.mpasc.connecttoclass.spring.entity.ClassYear;
import com.mpasc.connecttoclass.spring.entity.FyBscLectureAttendance;
import com.mpasc.connecttoclass.spring.entity.Lecture;
import com.mpasc.connecttoclass.spring.entity.Student;
import com.mpasc.connecttoclass.spring.entity.StudentStatus;
import com.mpasc.connecttoclass.spring.entity.SyBscLectureAttendance;
import com.mpasc.connecttoclass.spring.entity.TyBscLectureAttendance;
import com.mpasc.connecttoclass.spring.entity.UserEntity;
import com.mpasc.connecttoclass.spring.repository.AssignmentRepositoryImpl;
import com.mpasc.connecttoclass.spring.repository.ClassYearRepositoryimpl;
import com.mpasc.connecttoclass.spring.repository.FyBscLectureAttRepositoryImpl;
import com.mpasc.connecttoclass.spring.repository.LectureRepositoryImpl;
import com.mpasc.connecttoclass.spring.repository.StudentRepositoryImpl;
import com.mpasc.connecttoclass.spring.repository.SubjectRepositoryImpl;
import com.mpasc.connecttoclass.spring.repository.SyBscLectureAttRepositoryImpl;
import com.mpasc.connecttoclass.spring.repository.TeacherRepositoryImpl;
import com.mpasc.connecttoclass.spring.repository.TyBscLectureAttRepositoryImpl;
import com.mpasc.connecttoclass.spring.repository.UserRepositoryImpl;
import com.mpasc.connecttoclass.spring.utility.FileUtil;

@Controller
public class ViewRenderController {
	
	
	private static final Logger logger= Logger.getLogger(ViewRenderController.class.getName());

	
	@Autowired
	LectureRepositoryImpl lectureRepo;
	
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
	SyBscLectureAttRepositoryImpl syBscLectureAttRepo;
	
	@Autowired
	TyBscLectureAttRepositoryImpl tyBscLectureAttRepo;
	
	@Autowired
	FyBscLectureAttRepositoryImpl fyBscLectureAttRepo;
	
	@GetMapping(value="/view-training/{id}")
	public String viewLecture(@PathVariable int id, HttpServletRequest request,HttpSession session,Model model) {
		
		List<ClassYear> classYearList= new ArrayList<ClassYear>();
		List<String>classList = new ArrayList<String>();
		List<String>deptList = new ArrayList<String>();
		int count=0;
		DateTimeFormatter dFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		DateTimeFormatter Formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime now = LocalDateTime.now();
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
		
		Lecture lecture=lectureRepo.getLectureById((long) id);
		Date currentDate= new Date(dFormatter.format(now));
		TemporalAccessor tmp= Formatter.parse(lecture.getLecturedate());
		Date lectureDate= new Date(dFormatter.format(tmp));
		
		if(currentDate.after(lectureDate)) {
			if(Integer.parseInt(lecture.getClassId())==1115) {
				
				List<FyBscLectureAttendance> list=	fyBscLectureAttRepo.findAttendance(lecture.getLectureId());
				count=list.size();
				
			}else if(Integer.parseInt(lecture.getClassId())==2115){
				
				List<SyBscLectureAttendance> list=	syBscLectureAttRepo.findAttendance(lecture.getLectureId());
				count=list.size();
				
			}else if(Integer.parseInt(lecture.getClassId())==3115) {
				
				List<TyBscLectureAttendance> list=	tyBscLectureAttRepo.findAttendance(lecture.getLectureId());
				count=list.size();
				
			}
			model.addAttribute("numberAttendies", count);
		}
		model.addAttribute("Lecture", lecture);
		
		
		}catch(Exception e) {
			logger.log(Level.SEVERE,"Exception occur while view Lecture  ",e);
			model.addAttribute("errorCode",HttpStatus.INTERNAL_SERVER_ERROR.value());
			model.addAttribute("errorMessage","Oops, something went wrong ");
			return "errors";
		}
		return "view-training";
	}
	
	
	@GetMapping(value="/view-assignment/{id}")
	public String viewAssignment(@PathVariable int id, HttpServletRequest request,HttpSession session,Model model) {
		
		List<ClassYear> classYearList= new ArrayList<ClassYear>();
		List<String>classList = new ArrayList<String>();
		List<String>deptList = new ArrayList<String>();
		String userId;
		String viwe;
		UserEntity userEntity = new UserEntity();
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
			viwe="submit-assignment";
		}else {
			viwe="view-assignment";
		}
		
		AssignmentEntity assignmentEntity=assignmentRepositoryImpl.getAssignmentEntityById((long) id);
		model.addAttribute("assignment", assignmentEntity);
		
		}catch(Exception e) {
			logger.log(Level.SEVERE,"Exception occur while view Assignment  ",e);
			model.addAttribute("errorCode",HttpStatus.INTERNAL_SERVER_ERROR.value());
			model.addAttribute("errorMessage","Oops, something went wrong ");
			return "errors";
		}
		return viwe;
	}
	
	@GetMapping(value="/view-attendance-sheet/{id}")
	public String viewAttendanceSheet(@PathVariable int id, HttpServletRequest request,HttpSession session,Model model) {
		
		List<StudentStatus>rollNumList = new ArrayList<StudentStatus>();
		List<String>headerList= new ArrayList<>();
		StudentStatus status=null;
		List<Long> tempList = new ArrayList<>();
		
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
		
		Lecture lecture=lectureRepo.getLectureById((long) id);
		headerList.add("Roll Number");
		headerList.add("Name");
		
			if(Integer.parseInt(lecture.getClassId())==1115) {
				
				List<FyBscLectureAttendance> list=	fyBscLectureAttRepo.findAttendance(lecture.getLectureId());
				
				 List<Student>studentList=studentRepo.getUserByClassId((long) 1115);
				 for(FyBscLectureAttendance fyBscLectureAtte : list) {
					 tempList.add(fyBscLectureAtte.getRoll_num()) ;
				 }
				 for(Student student : studentList) {
					 status=new StudentStatus();
					 if(tempList.contains(student.getRoll_num())) {
						 status.setAttendaceState("present");
						 status.setName(student.getName());
						 status.setRoll_num(student.getRoll_num());
						 rollNumList.add(status);
					 }else {
						 status.setAttendaceState("absent");
						 status.setName(student.getName());
						 status.setRoll_num(student.getRoll_num());
						 rollNumList.add(status);
					 }
					
				 }
				
				
			}else if(Integer.parseInt(lecture.getClassId())==2115){
				
				List<SyBscLectureAttendance> list=	syBscLectureAttRepo.findAttendance(lecture.getLectureId());
				 List<Student>studentList=studentRepo.getUserByClassId((long) 2115);
				 for(SyBscLectureAttendance syBscLectureAtte : list) {
					 tempList.add(syBscLectureAtte.getRoll_num()) ;
				 }
				
				 int index=0;
				 for(Student student : studentList) {
					 status=new StudentStatus();
					
					 if(tempList.contains(student.getRoll_num())) {
						 status.setAttendaceState("present");
						 status.setName(student.getName());
						 status.setRoll_num(student.getRoll_num());
						
						 rollNumList.add(index,status);
						 
					 }else {
						 status.setAttendaceState("absent");
						 status.setName(student.getName());
						 status.setRoll_num(student.getRoll_num());
						
						 rollNumList.add(index, status);
						 
					 }
					
					 index++;
				 }
				
				
			}else if(Integer.parseInt(lecture.getClassId())==3115) {
				
				List<TyBscLectureAttendance> list=	tyBscLectureAttRepo.findAttendance(lecture.getLectureId());
				List<Student>studentList=studentRepo.getUserByClassId((long) 3115);
				 for(TyBscLectureAttendance tyBscLectureAtte : list) {
					 tempList.add(tyBscLectureAtte.getRoll_num()) ;
				 }
				 for(Student student : studentList) {
					 status=new StudentStatus();
					 if(tempList.contains(student.getRoll_num())) {
						 status.setAttendaceState("present");
						 status.setName(student.getName());
						 status.setRoll_num(student.getRoll_num());
						 rollNumList.add(status);
					 }else {
						 status.setAttendaceState("absent");
						 status.setName(student.getName());
						 status.setRoll_num(student.getRoll_num());
						 rollNumList.add(status);
					 }
					// rollNumList.add(status);
				 }
				
			}
			//model.addAttribute("numberAttendies", count);
			model.addAttribute("lectureList", rollNumList);
			model.addAttribute("headerList", headerList);
		
		}catch(Exception e) {
			logger.log(Level.SEVERE,"Exception occur while view AttendanceSheet ",e);
			model.addAttribute("errorCode",HttpStatus.INTERNAL_SERVER_ERROR.value());
			model.addAttribute("errorMessage","Oops, something went wrong ");
			return "errors";
		}
		return "list-view";
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping(value="/view-submissions/{id}")
	public String viewSubmissions(@PathVariable int id, HttpServletRequest request,HttpSession session,Model model) {
		//ClassYear classYear= new ClassYear();
		
		List<StudentStatus>rollNumList = new ArrayList<StudentStatus>();
		List<String>headerList= new ArrayList<>();
		
		StudentStatus status=null;
		List<Long> tempList = new ArrayList<>();
		
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
		
		Lecture lecture=lectureRepo.getLectureById((long) id);
		headerList.add("Roll Number");
		headerList.add("Name");
		AssignmentEntity assignmentEntity=assignmentRepositoryImpl.getAssignmentEntityById((long) id);
		
		String path=fileUtil.decrypt(assignmentEntity.getAttachment());
		System.out.println("Path   ======>> "+path);
		File fileFolder= new File(path);
		String contents[] = fileFolder.list();
	     
	      for(int i=0; i<contents.length; i++) {
	    	
	         String[] tmpArr=contents[i].replace(".", ",").split(",");
	         if(tmpArr[0].matches("\\d+")) {
	        	
	        	 tempList.add(Long.parseLong(tmpArr[0]));
	         }
	      }
	      
	      List<Student>studentList= studentRepo.getUserByClassId(Long.parseLong(assignmentEntity.getClassId()) );
	      for(Student student : studentList) {
	    	 if(tempList.contains(student.getRoll_num())) {
	    		 status=new StudentStatus();
	    		 status.setAttendaceState("1");
	    		 status.setName(student.getName());
	    		 status.setRoll_num(student.getRoll_num());
	    	 }else {
	    		 status=new StudentStatus();
	    		 status.setAttendaceState("0");
	    		 status.setName(student.getName());
	    		 status.setRoll_num(student.getRoll_num());
	    	 }
	    	 rollNumList.add(status);
	      }
	     
	      Collections.sort(rollNumList, new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				StudentStatus s1= (StudentStatus)o1;
				StudentStatus s2= (StudentStatus)o2;
				return s1.getRoll_num().compareTo(s2.getRoll_num());
				 
			}
	    	  
	      });
			model.addAttribute("assignmentId", assignmentEntity.getAssignmentId());
			model.addAttribute("assignmentList", rollNumList);
			model.addAttribute("headerList", headerList);
		
		}catch(Exception e) {
			logger.log(Level.SEVERE,"Exception occur while view Submissions  ",e);
			model.addAttribute("errorCode",HttpStatus.INTERNAL_SERVER_ERROR.value());
			model.addAttribute("errorMessage","Oops, something went wrong ");
			return "errors";
		}
		return "list-view";
	}
	
	
	
}
