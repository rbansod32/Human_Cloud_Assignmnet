package com.SignupSignin.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.SignupSignin.Model.SignupSigninDetails;
import com.SignupSignin.Response.ReturnResponse;
import com.SignupSignin.Service.SignupSigninService;

@RestController
public class SignupSigninController {

	private static final Logger log = LoggerFactory.getLogger(SignupSigninController.class);
	
	@Autowired
	SignupSigninService userService;
	
	@ResponseBody
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/signupNewUser", method = RequestMethod.POST)
	public ReturnResponse signupNewUser(SignupSigninDetails signupSigninDetails) {
		
		log.info("signupNewUser controller called...");
		
		return userService.createNewUser(signupSigninDetails);
		
	}
	
	@ResponseBody
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/userSignIn", method = RequestMethod.POST)
	public ReturnResponse userSignIn(SignupSigninDetails signupSigninDetails) {
		
		log.info("userSignIn controller called...");
		
		return userService.validateUser(signupSigninDetails);
		
	}
	
}
