package com.hsbc.service;

import java.util.List;

import com.hsbc.dao.*;
import com.hsbc.exceptions.DidNotBorrowAssetException;
import com.hsbc.exceptions.NoUserFoundException;
import com.hsbc.exceptions.TransactionNotFound;
import com.hsbc.pojo.*;

public class BorrowServiceImpl implements BorrowService {
	private BorrowDao borrowDao;
	public BorrowServiceImpl() {
		borrowDao=BorrowDaoFactory.getBorrowDaoImplObject();
	}
	@Override
	public List<Borrow> getBorrowDetailsById(int UserId) throws DidNotBorrowAssetException {
		// TODO Auto-generated method stub
		return borrowDao.getBorrowDetailsById(UserId);
	}
	@Override
	public List<Borrow> getBorrowDetailsByCategory(String assetType) throws NoUserFoundException {
		// TODO Auto-generated method stub
		return borrowDao.getBorrowDetailsByCategory(assetType);
	}
	@Override
	public boolean isEligibleToBorrow(int userId) throws DidNotBorrowAssetException {
		// TODO Auto-generated method stub
		return borrowDao.isEligibleToBorrow(userId);
	}
	@Override
	public void addtransaction(Borrow newTransaction) {
		// TODO Auto-generated method stub
		borrowDao.addtransaction(newTransaction);
		}
	@Override
	public void addmessage(String message, int transacId) throws TransactionNotFound {
		// TODO Auto-generated method stub
		borrowDao.addmessage(message, transacId);
		
	}

}
