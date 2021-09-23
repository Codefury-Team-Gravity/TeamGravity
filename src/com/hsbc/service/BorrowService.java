package com.hsbc.service;

import java.util.List;

import com.hsbc.exceptions.AssetNotFoundException;
import com.hsbc.exceptions.AssetNotInStockException;
import com.hsbc.exceptions.DidNotBorrowAssetException;
import com.hsbc.exceptions.NoUserFoundException;
import com.hsbc.exceptions.TransactionNotFound;
import com.hsbc.pojo.Borrow;

public interface BorrowService {
public List<Borrow> getBorrowDetailsById(int UserId) throws DidNotBorrowAssetException,NoUserFoundException, AssetNotFoundException;
	
	//return Transaction details of given Asset Type
	public List<Borrow> getOverDueBorrowDetailsByCategory(String assetType) throws NoUserFoundException, DidNotBorrowAssetException, AssetNotFoundException;
	
	//check whether the user with given userId is eligible to borrow assets or not
	public boolean isEligibleToBorrow(int userId) throws DidNotBorrowAssetException, NoUserFoundException, AssetNotFoundException;
	
	//add transaction details 
	public boolean addtransaction(Borrow newTransaction) throws AssetNotFoundException, AssetNotInStockException, DidNotBorrowAssetException, NoUserFoundException ;

	
	//add remarks to transaction
	public void addmessage(String message,int transacId) throws TransactionNotFound;
}
