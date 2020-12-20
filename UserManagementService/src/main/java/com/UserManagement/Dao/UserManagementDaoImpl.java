package com.UserManagement.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.UserManagement.Model.UserDetails;

@Component
public class UserManagementDaoImpl implements UserManagementDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int addUserInfo(UserDetails userDetails) {
		
		String updateQuery = "";
		int updateCount = 0;
		
		try {
			
			updateQuery = "UPDATE USER_DETAILS SET First_Name = ?, Last_Name = ?, Contact_No = ?, Email = ?, City = ?, State = ?, Country = ?, Pincode = ? WHERE User_Name = ?";
			
			updateCount = jdbcTemplate.update(updateQuery, 
					userDetails.getFirstName(),
					userDetails.getLastName(),
					userDetails.getContactNo(),
					userDetails.getEmail(),
					userDetails.getCity(),
					userDetails.getState(),
					userDetails.getCountry(),
					userDetails.getPincode(),
					userDetails.getUsername());
		
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		
		return updateCount;
	}

}
