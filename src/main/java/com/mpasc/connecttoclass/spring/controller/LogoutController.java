package com.mpasc.connecttoclass.spring.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {
	
	private static final Logger logger = Logger.getLogger(LogoutController.class.toString());
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request,HttpSession session) {
		try {
		session=request.getSession(false);
		if(session!=null) {
			
			if(session.getAttribute("id")!=null&&session.getAttribute("id").equals(session.getId())) {
				session.removeAttribute("id");
				
				session.setMaxInactiveInterval(0);
				session.invalidate();
			}
			}
		}catch(Exception e) {
			logger.log(Level.SEVERE,"Exception occur in logout while logging out user    ",e);
		}
		return "redirect:/";
	}

}
