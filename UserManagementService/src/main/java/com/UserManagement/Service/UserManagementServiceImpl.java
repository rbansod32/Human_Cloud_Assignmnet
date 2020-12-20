package com.UserManagement.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.UserManagement.Dao.UserManagementDao;
import com.UserManagement.Model.UserDetails;
import com.UserManagement.Response.ReturnResponse;

@Component
public class UserManagementServiceImpl implements UserManagementService {

	private static final Logger log = LoggerFactory.getLogger(UserManagementServiceImpl.class);
	
	@Autowired
	UserManagementDao daoObj;

	@Override
	public ReturnResponse addUserInfo(UserDetails userDetails) {
		
		ReturnResponse response = new ReturnResponse();
		
		int addCount = 0;
	
		addCount = daoObj.addUserInfo(userDetails);
		
		if(addCount > 0) {
			response.setResponseMessage("SUCCESS");
		}else {
			response.setResponseMessage("FAIL");
		}

		return response;
	}
	
}
