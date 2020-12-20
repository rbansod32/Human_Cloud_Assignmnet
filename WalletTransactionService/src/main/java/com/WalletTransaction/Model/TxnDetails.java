package com.WalletTransaction.Model;

public class TxnDetails {

	private String Username;
	private String ContactNo;
	private String SenderContactNo;
	private Double ReceiverContactNo;
	private Double Amt;

	public String getUsername() {
		return Username;
	}

	public String getContactNo() {
		return ContactNo;
	}

	public String getSenderContactNo() {
		return SenderContactNo;
	}

	public Double getReceiverContactNo() {
		return ReceiverContactNo;
	}

	public Double getAmt() {
		return Amt;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public void setContactNo(String contactNo) {
		ContactNo = contactNo;
	}

	public void setSenderContactNo(String senderContactNo) {
		SenderContactNo = senderContactNo;
	}

	public void setReceiverContactNo(Double receiverContactNo) {
		ReceiverContactNo = receiverContactNo;
	}

	public void setAmt(Double amt) {
		Amt = amt;
	}

}
