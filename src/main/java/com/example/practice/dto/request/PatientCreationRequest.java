package com.example.practice.dto.request;

public class PatientCreationRequest {
	
	private String name;
	
	private String hospital;
	
	private String disease;
	
	//private List<String> diseases;
	
	//private List<String> medicines;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	@Override
	public String toString() {
		return "PatientAdditionRequest [name=" + name + ", hospital=" + hospital + ", disease=" + disease + "]";
	}

	public PatientCreationRequest(String name, String hospital, String disease) {
		super();
		this.name = name;
		this.hospital = hospital;
		this.disease = disease;
	}

	

}
