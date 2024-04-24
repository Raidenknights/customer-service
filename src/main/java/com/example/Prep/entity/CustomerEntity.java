package com.example.Prep.entity;

import javax.validation.constraints.Pattern;

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
	private String id;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name= "Address")
	private String address;
	
	@Pattern(regexp="\\d+")
	@Column(name = "PhoneNo.")
	private Long phoneNumber;
	
	@Column(name = "GovtID-Proof")
	private String govtIdProof;

}
