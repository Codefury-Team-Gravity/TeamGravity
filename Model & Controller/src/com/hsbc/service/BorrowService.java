package com.hsbc.service;

import java.util.List;

import com.hsbc.exceptions.DidNotBorrowAssetException;
import com.hsbc.exceptions.NoUserFoundException;
import com.hsbc.exceptions.TransactionNotFound;
import com.hsbc.pojo.Borrow;

public interface BorrowService {
public List<Borrow> getBorrowDetailsById(int UserId) throws DidNotBorrowAssetException;
	
	//return Transaction details of given Asset Type
	public List<Borrow> getBorrowDetailsByCategory(String assetType) throws NoUserFoundException;
	
	//check whether the user with given userId is eligible to borrow assets or not
	public boolean isEligibleToBorrow(int userId) throws DidNotBorrowAssetException;
	
	//add transaction details 
	public void addtransaction(Borrow newTransaction);
	
	//add remarks to transaction
	public void addmessage(String message,int transacId) throws TransactionNotFound;
}
