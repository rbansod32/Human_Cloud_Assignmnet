package com.UserManagement.Dao;

import org.springframework.stereotype.Component;

import com.UserManagement.Model.UserDetails;

@Component
public interface UserManagementDao {

	int addUserInfo(UserDetails userDetails);

}
