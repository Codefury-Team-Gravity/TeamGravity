package com.hsbc.pojo;

import java.util.Date;

public class Asset {
	private int assetId;
	private String name;
	private String assetType;
	private String description;
	private Date dateOfAdded;
	private boolean isAvailable;
	//count++

	// default constructor
	public Asset() {
		super();
	}

	// constructor with parameters
	public Asset(int assetId, String name, String assetType, String description, Date dateOfAdded,
			boolean isAvailable) {
		super();
		this.assetId = assetId;
		this.name = name;
		this.description = description;
		this.dateOfAdded = dateOfAdded;
		this.isAvailable = isAvailable;
		this.assetType = assetType;
	}

	// getters and setters
	public int getAssetId() {
		return assetId;
	}

	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateOfAdded() {
		return dateOfAdded;
	}

	public void setDateOfAdded(Date dateOfAdded) {
		this.dateOfAdded = dateOfAdded;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getAssetType() {
		return assetType;
	}

	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}

	@Override
	public String toString() {
		return "Asset [assetId=" + assetId + ", name=" + name + ", assetType=" + assetType + ", description="
				+ description + ", dateOfAdded=" + dateOfAdded + ", isAvailable=" + isAvailable + "]";
	}

	 
}
