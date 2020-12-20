package com.UserManagement.Service;

import org.springframework.stereotype.Service;

import com.UserManagement.Model.UserDetails;
import com.UserManagement.Response.ReturnResponse;

@Service
public interface UserManagementService {

	ReturnResponse addUserInfo(UserDetails userDetails);

}
