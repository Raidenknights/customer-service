package com.example.practice.service.impl;

import org.springframework.stereotype.Service;

import com.example.practice.dto.request.PatientCreationRequest;
import com.example.practice.entity.PatientDetailsEntity;
import com.example.practice.repository.PatientRepository;
import com.example.practice.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService{
	
	PatientRepository patientRepository;
	
	public PatientServiceImpl(PatientRepository patientRepository) {
		// TODO Auto-generated constructor stub
		this.patientRepository=patientRepository;
	}

	@Override
	public String addPatient(PatientCreationRequest patientAdditionRequest) {
		// TODO Auto-generated method stub
		PatientDetailsEntity patientEntity = setPatientDetailsEntity(patientAdditionRequest);
		patientRepository.save(patientEntity);
		return null;
	}
	
	private PatientDetailsEntity  setPatientDetailsEntity(PatientCreationRequest patientCreationRequest) {
		
		PatientDetailsEntity patientEntity = new PatientDetailsEntity();
		
		patientEntity.setName(patientCreationRequest.getName());
		patientEntity.setHospital(patientCreationRequest.getHospital());
		patientEntity.setDiseases(patientCreationRequest.getDisease());
		
		return patientEntity;
	}

}
