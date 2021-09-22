package com.hsbc.pojo;

public class User {
	private int userId;
	private String name;
	private String role;
	private String phoneNumber;
	private String email;
	private String userName;

	//default constructor
	public User() {
		super();
	}

	//constructor with parameters
	public User(int userId, String name, String role, String phoneNumber, String email, String userName) {
		super();
		this.userId = userId;
		this.name = name;
		this.role = role;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.userName = userName;
	}

	//getters and setters
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", role=" + role + ", phoneNumber=" + phoneNumber
				+ ", email=" + email + ", userName=" + userName + "]";
	}

}
