package com.hsbc.exceptions;

public class AssetNotFoundException extends Exception{
	 
	private static final long serialVersionUID = 1L;
	public AssetNotFoundException(String msg)
	{
		super(msg);
	}
	public AssetNotFoundException(String message,Throwable cause)
	{
		super(message,cause);
	}
	public AssetNotFoundException(Throwable cause)
	{
		super(cause);
	}
	protected AssetNotFoundException(String message,Throwable cause, boolean enableSuppression,boolean writableStackTrace)
	{
		super(message,cause,enableSuppression,writableStackTrace);
	}
}
