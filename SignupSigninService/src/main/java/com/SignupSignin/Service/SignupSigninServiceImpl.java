package com.SignupSignin.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.SignupSignin.Dao.SignupSigninDao;
import com.SignupSignin.Model.ResultSetMapper;
import com.SignupSignin.Model.SignupSigninDetails;
import com.SignupSignin.Response.ReturnResponse;

@Component
public class SignupSigninServiceImpl implements SignupSigninService {

	@Autowired
	SignupSigninDao daoObj;
	
	@Override
	public ReturnResponse createNewUser(SignupSigninDetails signupSigninDetails) {
		
		ReturnResponse response = new ReturnResponse();
		
		int insertCount = 0;
	
		insertCount = daoObj.insertNewUser(signupSigninDetails);
		
		if(insertCount > 0) {
			response.setResponseMessage("SUCCESS");
			
		}else {
			response.setResponseMessage("FAIL");
		}

		return response;
	}

	@Override
	public ReturnResponse validateUser(SignupSigninDetails signupSigninDetails) {

		ReturnResponse response = new ReturnResponse();
		
		List<ResultSetMapper> userLoginDetails = null;
		
		String returnResult = "";
	
		userLoginDetails = daoObj.checkValidUser(signupSigninDetails);
		
		if(userLoginDetails.size() > 0) {
			
			for(ResultSetMapper curRec : userLoginDetails) {
				
				if(curRec.getStrField2().equals(signupSigninDetails.getPassword())) {
					returnResult = "SUCCESS";
					response.setResponseData(curRec.getStrField3() + "|" + curRec.getStrField4());
				}else {
					returnResult = "Wrong password, try again..!!";
				}
				
			}
			
		}else {
			returnResult = "No Account found with this credentials";
		}
		
		
		response.setResponseMessage(returnResult);
		
		return response;
	}
	

}
