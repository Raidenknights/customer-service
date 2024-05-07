package com.example.Prep.dto.request;

public class Customer {

	private String customerId;

	private String username;

	private String password;

	private boolean enabled;

	private String email;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Customer(String customerId, String username, String password, boolean enabled, String email) {
		super();
		this.customerId = customerId;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.email = email;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", username=" + username + ", password=" + password + ", enabled="
				+ enabled + ", email=" + email + "]";
	}

}
