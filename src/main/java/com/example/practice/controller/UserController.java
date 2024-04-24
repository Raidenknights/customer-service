package com.example.practice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.practice.constants.Constants;
import com.example.practice.dto.User;
import com.example.practice.dto.request.PatientCreationRequest;
import com.example.practice.service.PatientService;
import com.example.practice.service.UserService;

import jakarta.validation.Valid;

//This will be basic CRUD controller for Graph database
@RestController
public class UserController {

	UserService userService;
	
	PatientService patientService;

	UserController(UserService userService,PatientService patientService) {
		this.userService = userService;
		this.patientService=patientService;
	}
	
	@PostMapping(path = "add/patient")
	public ResponseEntity<String> addPatientToDatabase(PatientCreationRequest patientAdditionRequest){
		
		patientService.addPatient(patientAdditionRequest);
		
		return new ResponseEntity<>("Paitent Created SuccessFully",HttpStatus.OK);
	}

	@GetMapping(path = Constants.GET_USER)
	public ResponseEntity<User> getUserDetails(String accountNumber) {

		return new ResponseEntity<>(userService.getUserDetails(accountNumber), HttpStatus.OK);
	}

	@PostMapping(path = Constants.CREATE_USER)
	public ResponseEntity<String> registerUser(@RequestBody @Valid User user) {

		return new ResponseEntity<>(userService.addUser(user), HttpStatus.ACCEPTED);

	}

	@DeleteMapping(path = Constants.DELETE_USER)
	public ResponseEntity<String> deleteUser(String accountNumber) {

		return new ResponseEntity<>(userService.deleteUser(accountNumber), HttpStatus.ACCEPTED);

	}

}
