package com.hsbc.pojo;

import java.util.Date;

public class Borrow {
	private String transactionId;
	private int userId;
	private int assetId;
	private String remarks;
	private Date dateOfBorrow;
	private boolean isReturned;
	private Date dateOfReturn;

	// default constructor
	public Borrow() {
		super();
	}

	// constructor with parameters
	public Borrow(String transactionId, int userId, int assetId, String remarks, Date dateOfBorrow, boolean isReturned,
			Date dateOfReturn) {
		super();
		this.transactionId = transactionId;
		this.userId = userId;
		this.assetId = assetId;
		this.remarks = remarks;
		this.dateOfBorrow = dateOfBorrow;
		this.isReturned = isReturned;
		this.dateOfReturn = dateOfReturn;
	}

	// getters and setters
	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public int getAssetId() {
		return assetId;
	}

	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Date getDateOfBorrow() {
		return dateOfBorrow;
	}

	public void setDateOfBorrow(Date dateOfBorrow) {
		this.dateOfBorrow = dateOfBorrow;
	}

	public boolean isReturned() {
		return isReturned;
	}

	public void setReturned(boolean isReturned) {
		this.isReturned = isReturned;
	}

	public Date getDateOfReturn() {
		return dateOfReturn;
	}

	public void setDateOfReturn(Date dateOfReturn) {
		this.dateOfReturn = dateOfReturn;
	}

	@Override
	public String toString() {
		return "Borrow [transactionId=" + transactionId + ", userId=" + userId + ", assetId=" + assetId + ", remarks="
				+ remarks + ", dateOfBorrow=" + dateOfBorrow + ", isReturned=" + isReturned + ", dateOfReturn="
				+ dateOfReturn + "]";
	}

}