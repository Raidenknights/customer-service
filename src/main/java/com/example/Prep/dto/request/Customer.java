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
	
	private String customerId;
	
	private String username;
	
	private String password;
	
	private boolean enabled;

}
