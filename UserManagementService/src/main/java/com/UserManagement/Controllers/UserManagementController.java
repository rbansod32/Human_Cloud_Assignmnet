package com.UserManagement.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.UserManagement.Model.UserDetails;
import com.UserManagement.Response.ReturnResponse;
import com.UserManagement.Service.UserManagementService;

@RestController
public class UserManagementController {

	private static final Logger log = LoggerFactory.getLogger(UserManagementController.class);
	
	@Autowired
	UserManagementService userService;
	
	@ResponseBody
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/addUserInfo", method = RequestMethod.POST)
	public ReturnResponse addUserInfo(UserDetails userDetails) {
		
		log.info("addUserInfo controller called...");
		
		return userService.addUserInfo(userDetails);
		
	}
	
}
