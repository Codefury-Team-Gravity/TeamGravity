package com.hsbc.exceptions;

public class CategoryNotException extends Exception{
	private static final long serialVersionUID = 1L;
	public CategoryNotException(String msg)
	{
		super(msg);
	}
	public CategoryNotException(String message,Throwable cause)
	{
		super(message,cause);
	}
	public CategoryNotException(Throwable cause)
	{
		super(cause);
	}
	protected CategoryNotException(String message,Throwable cause, boolean enableSuppression,boolean writableStackTrace)
	{
		super(message,cause,enableSuppression,writableStackTrace);
	}
}
