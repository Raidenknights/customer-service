package com.example.Prep.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Class created as entity class for customer.
 * 
 * @author Manas Vishnoi
 */
@Entity
@Table(name = "customers")
public class CustomerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private String customerId;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "enabled")
	private boolean enabled;

	@Column(name = "registration_date")
	private Date registrationDate;

	@Column(name = "email")
	private String email;

	@Column(name = "role")
	private String role;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

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

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "CustomerEntity [customerId=" + customerId + ", username=" + username + ", password=" + password
				+ ", enabled=" + enabled + ", registrationDate=" + registrationDate + "]";
	}

	public CustomerEntity(String customerId, String username, String password, boolean enabled, Date registrationDate,
			String email, String role) {
		super();
		this.customerId = customerId;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.registrationDate = registrationDate;
		this.email = email;
		this.role = role;
	}

	public CustomerEntity() {
		super();
	}

}
