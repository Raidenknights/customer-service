package com.example.practice.entity;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node(labels = {"Medicine"})
public class MedicineCreationEntity {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String medicineName;
	
	private String targetDisease;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
		return "MedicineCreationEntity [id=" + id + ", medicineName=" + medicineName + ", targetDisease="
				+ targetDisease + "]";
	}

	public MedicineCreationEntity(Long id, String medicineName, String targetDisease) {
		super();
		this.id = id;
		this.medicineName = medicineName;
		this.targetDisease = targetDisease;
	}
	
	

}
