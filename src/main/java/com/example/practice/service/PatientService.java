package com.example.practice.service;

import org.springframework.stereotype.Service;

import com.example.practice.dto.request.PatientCreationRequest;

@Service
public interface PatientService {
	
	String addPatient(PatientCreationRequest patientAdditionRequest);
	

}
