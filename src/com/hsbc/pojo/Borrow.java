package com.hsbc.pojo;

import java.sql.Date;

public class Borrow {
	private int transactionId;
	private User user;
	private Asset asset;
	private String remarks;
	private Date dateOfBorrow;
	private boolean isReturned;
	private Date dateOfReturn;
	private double lateFee;
	
	// default constructor
	public Borrow() {
		super();
	}

	// constructor with parameters
	public Borrow(User user, Asset asset) {
		super();
		//this.transactionId = transactionId;
		this.user = user;
		this.asset = asset;
	}
	
	public Borrow(int transactionId, User user, Asset asset, String remarks, Date dateOfBorrow, boolean isReturned,
			Date dateOfReturn,double lateFee) {
		super();
		this.transactionId = transactionId;
		this.user = user;
		this.asset = asset;
		this.remarks = remarks;
		this.dateOfBorrow = dateOfBorrow;
		this.isReturned = isReturned;
		this.dateOfReturn = dateOfReturn;
		this.lateFee=lateFee;
	}

	// getters and setters
	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public Asset getAsset() {
		return asset;
	}

	public void setAsset(Asset asset) {
		this.asset = asset;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
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
	
	public double getLateFee() {
		return lateFee;
	}

	public void setLateFee(double lateFee) {
		this.lateFee = lateFee;
	}

	@Override
	public String toString() {
		return "Borrow [transactionId=" + transactionId + ", userId=" + user + ", assetId=" + asset + ", remarks="
				+ remarks + ", dateOfBorrow=" + dateOfBorrow + ", isReturned=" + isReturned + ", dateOfReturn="
				+ dateOfReturn + ", lateFee=" + lateFee + "]";
	}

}