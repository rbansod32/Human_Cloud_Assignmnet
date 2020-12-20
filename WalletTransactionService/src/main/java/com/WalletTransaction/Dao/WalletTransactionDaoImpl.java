package com.WalletTransaction.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.WalletTransaction.Model.ResultSetMapper;
import com.WalletTransaction.Model.TxnDetails;

@Component
@SuppressWarnings({ "unchecked", "rawtypes" })
public class WalletTransactionDaoImpl implements WalletTransactionDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int addFundToWallet(TxnDetails txnDetails) {
		
		String updateQuery = "";
		int updateCount = 0;

		try {
		
			updateQuery = "UPDATE USER_DETAILS SET Available_Fund = Available_Fund + "+txnDetails.getAmt()+" WHERE User_Name = ?";
			
			updateCount = jdbcTemplate.update(updateQuery, txnDetails.getUsername());

		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		
		return updateCount;
		
	}

	@Override
	public int transferFund(TxnDetails txnDetails) {
		
		String insertQuery = "";
		int insertCount = 0;
		
		String updateQuery = "";
		int updateCount = 0;
		
		String txnType = "";
		String txnRefNo = "";
				
		String txnDate = "";
		
		try {
			
			txnDate = formatDate(new Date(), "yyyy-MM-dd");
			
			txnType = "D";
			txnRefNo = txnDetails.getUsername()+"_"+txnType+"_"+String.valueOf(txnDetails.getReceiverContactNo());
			
			
			insertQuery = "INSERT INTO TXN_DETAILS(Txn_Type, Txn_Ref_No, Dr_Amt, Dr_Contact_No, Txn_Owner, Txn_Date)VALUES(?,?,?,?,?,?)";
			
			insertCount = jdbcTemplate.update(insertQuery,
					txnType,
					txnRefNo,
					txnDetails.getAmt(),
					txnDetails.getReceiverContactNo(),
					txnDetails.getSenderContactNo(),
					txnDate);
			
			
			txnType = "C";
			txnRefNo = txnDetails.getUsername()+"_"+txnType+"_"+String.valueOf(txnDetails.getSenderContactNo());
			
			insertQuery = "INSERT INTO TXN_DETAILS(Txn_Type, Txn_Ref_No, Cr_Amt, Cr_Contact_No, Txn_Owner, Txn_Date)VALUES(?,?,?,?,?,?)";
			
			insertCount = jdbcTemplate.update(insertQuery,
					txnType,
					txnRefNo,
					txnDetails.getAmt(),
					txnDetails.getSenderContactNo(),
					txnDetails.getReceiverContactNo(),
					txnDate);
		
			
			updateQuery = "UPDATE USER_DETAILS SET Available_Fund = Available_Fund - "+txnDetails.getAmt()+" WHERE Contact_No = ?";
			
			updateCount = jdbcTemplate.update(updateQuery, txnDetails.getSenderContactNo());
			
			
			updateQuery = "UPDATE USER_DETAILS SET Available_Fund = Available_Fund + "+txnDetails.getAmt()+" WHERE Contact_No = ?";
			
			updateCount = jdbcTemplate.update(updateQuery, txnDetails.getReceiverContactNo());
			
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		
		return insertCount;
	}
	
	
	public static String formatDate(Date inputDate, String outputFormat) {
		
		if(inputDate == null)
			return "";
		
		SimpleDateFormat sdf = new SimpleDateFormat(outputFormat);
		String outDate = "";

		outDate = sdf.format(inputDate);

		return outDate;
	}

	@Override
	public List<ResultSetMapper> fetchTransactions(TxnDetails txnDetails) {
		
		List<ResultSetMapper> queryResult = null;
		
		String selectSql = "";
		
		DecimalFormat contactformatter = new DecimalFormat("0");
		
		try {
			
			selectSql = "SELECT Txn_Type, Txn_Ref_No, Cr_Amt, Dr_Amt, Cr_Contact_No, Dr_Contact_No, Txn_Owner, Txn_Date FROM TXN_DETAILS WHERE Txn_Owner = '"+txnDetails.getContactNo()+"'";
			
			queryResult = jdbcTemplate.query(selectSql, new RowMapper() {
				@Override
				public ResultSetMapper mapRow(ResultSet rs, int rownumber) throws SQLException {
					
					ResultSetMapper rsm = new ResultSetMapper();
					
					rsm.setStrField1(rs.getString(1));
					rsm.setStrField2(rs.getString(2));
					rsm.setStrField3(rs.getString(3));
					rsm.setStrField4(rs.getString(4));
					rsm.setStrField5(contactformatter.format(rs.getDouble(5)));
					rsm.setStrField6(contactformatter.format(rs.getDouble(6)));
					rsm.setStrField7(contactformatter.format(rs.getDouble(7)));
					rsm.setStrField8(rs.getString(8));
					
					return rsm;
				
				}
				
			});
		
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		
		return queryResult;
	}
	
}
