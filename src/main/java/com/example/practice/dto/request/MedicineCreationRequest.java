package com.example.practice.dto.request;

public class MedicineCreationRequest {
	
	private String medicineName;
	
	//Can be a list also but maintaining a simple approach for learning
	private String targetDisease;

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public String getTargetDisease() {
		return targetDisease;
	}

	public void setTargetDisease(String targetDisease) {
		this.targetDisease = targetDisease;
	}

	@Override
	public String toString() {
		return "MedicineAdditionRequest [ medicineName=" + medicineName + ", targetDisease="
				+ targetDisease + "]";
	}

	public MedicineCreationRequest(String medicineName, String targetDisease) {
		super();
		this.medicineName = medicineName;
		this.targetDisease = targetDisease;
	}

}
