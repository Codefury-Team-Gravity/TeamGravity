package com.hsbc.exceptions;

public class DidNotBorrowAssetException extends Exception{
	 
	private static final long serialVersionUID = 1L;
	public DidNotBorrowAssetException(String msg)
	{
		super(msg);
	}
	public DidNotBorrowAssetException(String message,Throwable cause)
	{
		super(message,cause);
	}
	public DidNotBorrowAssetException(Throwable cause)
	{
		super(cause);
	}
	protected DidNotBorrowAssetException(String message,Throwable cause, boolean enableSuppression,boolean writableStackTrace)
	{
		super(message,cause,enableSuppression,writableStackTrace);
	}
}
