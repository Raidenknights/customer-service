package com.example.practice.service;

import com.example.practice.dto.User;

public interface UserService {

	String addUser(User user);
	String deleteUser(String accountNumber);
	String updateUser(User user);
	User getUserDetails(String accountNumber);

}
