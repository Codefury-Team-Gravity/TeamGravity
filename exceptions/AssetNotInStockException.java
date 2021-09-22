package com.hsbc.exceptions;

public class AssetNotInStockException extends Exception{
	private static final long serialVersionUID = 1L;
	public AssetNotInStockException(String msg)
	{
		super(msg);
	}
	public AssetNotInStockException(String message,Throwable cause)
	{
		super(message,cause);
	}
	public AssetNotInStockException(Throwable cause)
	{
		super(cause);
	}
	protected AssetNotInStockException(String message,Throwable cause, boolean enableSuppression,boolean writableStackTrace)
	{
		super(message,cause,enableSuppression,writableStackTrace);
	}
}
