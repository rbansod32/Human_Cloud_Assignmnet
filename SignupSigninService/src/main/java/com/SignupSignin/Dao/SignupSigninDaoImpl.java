package com.SignupSignin.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.SignupSignin.Model.ResultSetMapper;
import com.SignupSignin.Model.SignupSigninDetails;

@Component
@SuppressWarnings({"unchecked", "rawtypes"})
public class SignupSigninDaoImpl implements SignupSigninDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int insertNewUser(SignupSigninDetails signupSigninDetails) {
		
		int insertCount = 0;
		String insertSql = "";
		
		try {
			
			insertSql = "INSERT INTO USER_DETAILS(User_Name,Password)VALUES();";
			
			insertCount = jdbcTemplate.update(insertSql);
		
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		
		return insertCount;
	}

	@Override
	public List<ResultSetMapper> checkValidUser(SignupSigninDetails signupSigninDetails) {

		List<ResultSetMapper> queryResult = null;
		
		String selectSql = "";
		
		DecimalFormat contactformatter = new DecimalFormat("0");
		DecimalFormat amtformatter = new DecimalFormat("0.00");
		
		try {
			
			selectSql = "SELECT User_Name, Password, Contact_No, Available_Fund FROM USER_DETAILS WHERE User_Name = '"+signupSigninDetails.getUsername()+"'";
			
			queryResult = jdbcTemplate.query(selectSql, new RowMapper() {
				
				@Override
				public ResultSetMapper mapRow(ResultSet rs, int rownumber) throws SQLException {
					
					ResultSetMapper rsm = new ResultSetMapper();
					
					rsm.setStrField1(rs.getString(1));
					rsm.setStrField2(rs.getString(2));
					rsm.setStrField3(String.valueOf(contactformatter.format(rs.getDouble(3))));
					rsm.setStrField4(String.valueOf(amtformatter.format(rs.getDouble(4))));
					
					return rsm;
					
				}
			});
		
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		
		return queryResult;
	}

}
