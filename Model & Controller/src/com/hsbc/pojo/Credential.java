package com.hsbc.pojo;

public class Credential {
	private String userName;
	private String password;

	//default constructor
	public Credential() {
		super();
	}

	//constructor with parameters
	public String getUserName() {
		return userName;
	}

	//getters and setters
	public Credential(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Credential [userName=" + userName + ", password=" + password + "]";
	}

}
