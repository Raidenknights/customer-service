package com.example.practice.dto;

public class User {
	
	private String name;
	
	private String address;
	
	private String accountNumber;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", address=" + address + ", accountNumber=" + accountNumber + "]";
	}
	
	

}
