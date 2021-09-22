package com.hsbc.exceptions;

public class NoUserFoundException extends Exception{
	 
	private static final long serialVersionUID = 1L;
	public NoUserFoundException(String msg)
	{
		super(msg);
	}
	public NoUserFoundException(String message,Throwable cause)
	{
		super(message,cause);
	}
	public NoUserFoundException(Throwable cause)
	{
		super(cause);
	}
	protected NoUserFoundException(String message,Throwable cause, boolean enableSuppression,boolean writableStackTrace)
	{
		super(message,cause,enableSuppression,writableStackTrace);
	}
}
