package com.hsbc.exceptions;

public class UserAlreadyPresentException extends Exception{
	private static final long serialVersionUID = 1L;
	public UserAlreadyPresentException(String msg)
	{
		super(msg);
	}
	public UserAlreadyPresentException(String message,Throwable cause)
	{
		super(message,cause);
	}
	public UserAlreadyPresentException(Throwable cause)
	{
		super(cause);
	}
	protected UserAlreadyPresentException(String message,Throwable cause, boolean enableSuppression,boolean writableStackTrace)
	{
		super(message,cause,enableSuppression,writableStackTrace);
	}
}
