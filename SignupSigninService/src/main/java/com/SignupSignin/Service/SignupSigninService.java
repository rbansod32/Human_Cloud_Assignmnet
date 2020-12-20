package com.SignupSignin.Service;

import org.springframework.stereotype.Service;

import com.SignupSignin.Model.SignupSigninDetails;
import com.SignupSignin.Response.ReturnResponse;

@Service
public interface SignupSigninService {

	ReturnResponse createNewUser(SignupSigninDetails signupSigninDetails);
	
	ReturnResponse validateUser(SignupSigninDetails signupSigninDetails);
	
}
