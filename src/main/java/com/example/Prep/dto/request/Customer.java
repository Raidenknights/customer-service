package com.example.Prep.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Customer {
	private String name;
	
	private String address;
	
	private Long phoneNumber;
	
	private String govtIdProof;

}
