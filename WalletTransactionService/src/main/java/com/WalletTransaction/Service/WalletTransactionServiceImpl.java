package com.WalletTransaction.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Component;

import com.WalletTransaction.Dao.WalletTransactionDao;
import com.WalletTransaction.Model.ResultSetMapper;
import com.WalletTransaction.Model.TxnDetails;
import com.WalletTransaction.Response.ReturnResponse;

@Component
public class WalletTransactionServiceImpl implements WalletTransactionService{

	private static final Logger log = LoggerFactory.getLogger(WalletTransactionServiceImpl.class);

	@Autowired
	WalletTransactionDao walletTransactionDao;
	
	@Override
	public ReturnResponse addFundToWallet(TxnDetails txnDetails) {
		
		log.info("inside addFundToWallet...");
		
		ReturnResponse response = new ReturnResponse();
		
		int txnInsertCount = 0;
		
		txnInsertCount = walletTransactionDao.addFundToWallet(txnDetails);
		
		if(txnInsertCount > 0) {
			response.setResponseMessage("SUCCESS");
		}else {
			response.setResponseMessage("FAIL");
		}

		return response;
	}

	@Override
	public ReturnResponse transferFund(TxnDetails txnDetails) {
		
		log.info("inside transferFund...");
		
		ReturnResponse response = new ReturnResponse();
		
		int txnInsertCount = 0;
		
		txnInsertCount = walletTransactionDao.transferFund(txnDetails);
		
		if(txnInsertCount > 0) {
			response.setResponseMessage("SUCCESS");
		}else {
			response.setResponseMessage("FAIL");
		}

		return response;
	}

	@Override
	public ReturnResponse showTransactions(TxnDetails txnDetails) {
		
		log.info("inside showTransactions...");
		
		ReturnResponse response = new ReturnResponse();
		
		List<ResultSetMapper> txnList = null;
		
		String returnResult = "";
	
		JSONObject allTxn = null;
		JSONArray allTxnArr = null;
		JSONObject singleTxn = null;
		
		txnList = walletTransactionDao.fetchTransactions(txnDetails);
		
		if(txnList.size() > 0) {
			
			allTxn = new JSONObject();
			allTxnArr = new JSONArray();
			
			for(ResultSetMapper curtxn : txnList) {
				
				singleTxn = new JSONObject();
				
				try {
					
					singleTxn.put("Txn_Type", curtxn.getStrField1());
					singleTxn.put("Txn_Ref_No", curtxn.getStrField2());
					singleTxn.put("Cr_Amt", curtxn.getStrField3());
					singleTxn.put("Dr_Amt", curtxn.getStrField4());
					singleTxn.put("Cr_Contact_No", curtxn.getStrField5());
					singleTxn.put("Dr_Contact_No", curtxn.getStrField6());
					singleTxn.put("Txn_Owner", curtxn.getStrField7());
					singleTxn.put("Txn_Date", curtxn.getStrField8());
				
					allTxnArr.put(singleTxn);
					
				} catch (JSONException e) {
					e.printStackTrace();
				}
				
			}
			
			try {
				allTxn.put("allTxn", allTxnArr);
			} catch (JSONException e) {
				e.printStackTrace();
			}
			returnResult = "SUCCESS";
			
		}else {
			returnResult = "No Account found with this credentials";
		}
		
		response.setResponseMessage(returnResult);
		response.setResponseData(allTxn.toString());
		
		return response;
	}
	
}
