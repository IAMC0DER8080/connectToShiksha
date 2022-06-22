package com.mpasc.connecttoclass.spring.controller;

import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mpasc.connecttoclass.spring.entity.UserEntity;
import com.mpasc.connecttoclass.spring.entity.UserSession;
import com.mpasc.connecttoclass.spring.repository.UserRepositoryImpl;

@Controller
public class LoginController {
	
	private static final Logger logger = Logger.getLogger(LoginController.class.toString());
	
	@Autowired
	UserRepositoryImpl userRepo;
	
	@Autowired
	UserSession userSession;
	
	@GetMapping("/")
	public String loginPage(Model model) {
		System.out.println("Here");
		UserEntity user = new UserEntity();
		model.addAttribute("user",user);
		return  "login"; 
	}

	@PostMapping("/validate") 
	public String validate(@ModelAttribute("user")UserEntity user, HttpSession session, HttpServletRequest request,Model model) {  
		try {
			
			Encoder encode=Base64.getEncoder();
			user=userRepo.getUser(user.getUserId());
			
			userSession.setDesignation(user.getDesignation());
			userSession.setId(user.getId());
			userSession.setUserId(user.getUserId());
			userSession.setUsername(user.getUsername());
				  
		}catch(Exception e) {
			logger.log(Level.SEVERE, "Exception occured in AjaxRestController.validate()   =====>>  ",e);
		}
		return "redirect:/dashboard";
	}
	
}
