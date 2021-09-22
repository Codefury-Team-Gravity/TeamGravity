package com.hsbc.exceptions;

public class AssetAlreadyPresentException extends Exception {
	 
	private static final long serialVersionUID = 1L;
	public AssetAlreadyPresentException(String msg)
	{
		super(msg);
	}
	public AssetAlreadyPresentException(String message,Throwable cause)
	{
		super(message,cause);
	}
	public AssetAlreadyPresentException(Throwable cause)
	{
		super(cause);
	}
	protected AssetAlreadyPresentException(String message,Throwable cause, boolean enableSuppression,boolean writableStackTrace)
	{
		super(message,cause,enableSuppression,writableStackTrace);
	}
}
