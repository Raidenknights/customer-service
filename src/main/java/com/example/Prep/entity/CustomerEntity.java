package com.example.Prep.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class CustomerEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id")
	private String customerId;
	
	@Column(name = "username")
	private String username;
	
	@Column(name= "password")
	private String password;

	@Column(name = "enabled")
	private boolean enabled;
	
	@Column(name = "registration_date")
	private Date registrationDate;

}
