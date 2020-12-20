package com.assignment.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppStartController {

	private static final Logger log = LoggerFactory.getLogger(AppStartController.class);
	
	@RequestMapping("/signin.html")
	public ModelAndView SignInPageShow() {
		log.info("signin controller called...");
		return new ModelAndView("signin");
	}

	@RequestMapping("/signup.html")
	public ModelAndView SignUpPageShow() {
		log.info("signup controller called...");
		return new ModelAndView("signup");
	}
	
	@RequestMapping("/dashboard.html")
	public ModelAndView DashboardPageShow() {
		log.info("dashboard controller called...");
		return new ModelAndView("dashboard");
	}
	
}
