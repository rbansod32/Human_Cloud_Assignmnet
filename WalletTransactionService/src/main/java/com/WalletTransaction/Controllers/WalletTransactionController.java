package com.WalletTransaction.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.WalletTransaction.Model.TxnDetails;
import com.WalletTransaction.Response.ReturnResponse;
import com.WalletTransaction.Service.WalletTransactionService;

@RestController
public class WalletTransactionController {

	private static final Logger log = LoggerFactory.getLogger(WalletTransactionController.class);
	
	@Autowired
	WalletTransactionService walletTransactionService;
	
	@ResponseBody
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/addWalletFund", method = RequestMethod.POST)
	public ReturnResponse addWalletFund(TxnDetails txnDetails) {
		
		log.info("addWalletFund controller called...");
		
		return walletTransactionService.addFundToWallet(txnDetails);
		
	}
	
	
	@ResponseBody
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/transferFund", method = RequestMethod.POST)
	public ReturnResponse transferFund(TxnDetails txnDetails) {
		
		log.info("transferFund controller called...");
		
		return walletTransactionService.transferFund(txnDetails);
		
	}
	
	
	@ResponseBody
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/showTransactions", method = RequestMethod.POST)
	public ReturnResponse showTransactions(TxnDetails txnDetails) {
		
		log.info("showTransactions controller called...");
		
		return walletTransactionService.showTransactions(txnDetails);
		
	}
	
}
