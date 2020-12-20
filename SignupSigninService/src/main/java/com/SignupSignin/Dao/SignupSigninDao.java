package com.SignupSignin.Dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.SignupSignin.Model.ResultSetMapper;
import com.SignupSignin.Model.SignupSigninDetails;

@Component
public interface SignupSigninDao {

	int insertNewUser(SignupSigninDetails signupSigninDetails);
	
	List<ResultSetMapper> checkValidUser(SignupSigninDetails signupSigninDetails);
	
}
