package com.hsbc.service;

import java.util.List;

import com.hsbc.dao.*;
import com.hsbc.exceptions.AssetNotFoundException;
import com.hsbc.exceptions.AssetNotInStockException;
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
	public List<Borrow> getBorrowDetailsById(int UserId) throws DidNotBorrowAssetException, NoUserFoundException, AssetNotFoundException {
			return borrowDao.getBorrowDetailsById(UserId);
	}
	@Override
	public List<Borrow> getOverDueBorrowDetailsByCategory(String assetType) throws NoUserFoundException, DidNotBorrowAssetException, AssetNotFoundException {
		
		return borrowDao.getOverDueBorrowDetailsByCategory(assetType);
	}
	@Override
	public boolean isEligibleToBorrow(int userId) throws DidNotBorrowAssetException, NoUserFoundException, AssetNotFoundException {
		// TODO Auto-generated method stub
		return borrowDao.isEligibleToBorrow(userId);
	}
	@Override
	public boolean addtransaction(Borrow newTransaction) throws AssetNotFoundException, AssetNotInStockException, DidNotBorrowAssetException, NoUserFoundException {
		// TODO Auto-generated method stub
		return borrowDao.addtransaction(newTransaction);
		}
	@Override
	public void addmessage(String message, int transacId) throws TransactionNotFound {
		// TODO Auto-generated method stub
		borrowDao.addmessage(message, transacId);
		
	}

}
