package com.WalletTransaction.Service;

import org.springframework.stereotype.Service;

import com.WalletTransaction.Model.TxnDetails;
import com.WalletTransaction.Response.ReturnResponse;

@Service
public interface WalletTransactionService {

	ReturnResponse addFundToWallet(TxnDetails txnDetails);

	ReturnResponse transferFund(TxnDetails txnDetails);

	ReturnResponse showTransactions(TxnDetails txnDetails);

}
