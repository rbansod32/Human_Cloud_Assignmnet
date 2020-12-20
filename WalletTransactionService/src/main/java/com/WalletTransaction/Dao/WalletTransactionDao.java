package com.WalletTransaction.Dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.WalletTransaction.Model.ResultSetMapper;
import com.WalletTransaction.Model.TxnDetails;

@Component
public interface WalletTransactionDao {

	int addFundToWallet(TxnDetails txnDetails);

	int transferFund(TxnDetails txnDetails);

	List<ResultSetMapper> fetchTransactions(TxnDetails txnDetails);

}
