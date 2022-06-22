package com.mpasc.connecttoclass.spring.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class CustomeErrorController implements ErrorController{


	@GetMapping("/error")
	public ModelAndView handleError(HttpServletRequest request) {

		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

		ModelAndView model = new ModelAndView();
		if (status != null) {

			Integer statusCode = Integer.valueOf(status.toString());

			if(statusCode == HttpStatus.NOT_FOUND.value()) {
				model.addObject("errorCode",HttpStatus.NOT_FOUND.value());
				model.addObject("errorMessage","Sorry, the resource you are looking for could not be found");
			}else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
				model.addObject("errorCode",HttpStatus.INTERNAL_SERVER_ERROR.value());
				model.addObject("errorMessage","Oops, something went wrong ");
			}else if(statusCode == HttpStatus.FORBIDDEN.value()) {
				model.addObject("errorCode",HttpStatus.FORBIDDEN.value());
				model.addObject("errorMessage","You don't have permission to access on this server ");
			}else if(statusCode == HttpStatus.SERVICE_UNAVAILABLE.value()) {
				model.addObject("errorCode",HttpStatus.SERVICE_UNAVAILABLE.value());
				model.addObject("errorMessage","Service unavailable, try again later ");
			}

			model.setViewName("errors");
		}

		return model;
	}



	public String getErrorPath() {
		// TODO Auto-generated method stub 
		return "/error";
	}

}
