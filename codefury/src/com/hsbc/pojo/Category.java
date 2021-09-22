package com.hsbc.pojo;

public class Category {
	private String assetType;
	private int lendingPeriod;
	private float lateFee;
	private int bannedDaysCount;

	//default constructor
	public Category() {
		super();
	}

	//constructor with parameters
	public Category(String assetType, int lendingPeriod, float lateFee, int bannedDaysCount) {
		super();
		this.assetType = assetType;
		this.lendingPeriod = lendingPeriod;
		this.lateFee = lateFee;
		this.bannedDaysCount = bannedDaysCount;
	}

	//getters and setters
	public String getAssetType() {
		return assetType;
	}

	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}

	public int getLendingPeriod() {
		return lendingPeriod;
	}

	public void setLendingPeriod(int lendingPeriod) {
		this.lendingPeriod = lendingPeriod;
	}

	public float getLateFee() {
		return lateFee;
	}

	public void setLateFee(float lateFee) {
		this.lateFee = lateFee;
	}

	public int getbannedDaysCount() {
		return bannedDaysCount;
	}

	public void setbannedDaysCount(int bannedDaysCount) {
		this.bannedDaysCount =bannedDaysCount;
	}

	@Override
	public String toString() {
		return "AssetType [assetType=" + assetType + ", lendingPeriod=" + lendingPeriod + ", lateFee=" + lateFee
				+ ", dayToKeep=" + bannedDaysCount + "]";
	}

}
