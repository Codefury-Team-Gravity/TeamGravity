package com.hsbc.exceptions;

public class TransactionNotFound extends Exception{
	private static final long serialVersionUID = 1L;
	public TransactionNotFound(String msg)
	{
		super(msg);
	}
	public TransactionNotFound(String message,Throwable cause)
	{
		super(message,cause);
	}
	public TransactionNotFound(Throwable cause)
	{
		super(cause);
	}
	protected TransactionNotFound(String message,Throwable cause, boolean enableSuppression,boolean writableStackTrace)
	{
		super(message,cause,enableSuppression,writableStackTrace);
	}
}
