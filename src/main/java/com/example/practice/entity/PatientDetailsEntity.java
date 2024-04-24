package com.example.practice.entity;

import java.util.List;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.Relationship.Direction;

@Node(labels = "Patient")
public class PatientDetailsEntity {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Property
	private String name;
	@Property
	private String hospital;
	@Property
	private String diseases;
	
	@Relationship(type = "MEDICINE_ASSIGNED", direction = Direction.OUTGOING)
	private List<MedicineCreationEntity> medicinesAssociated;
	
	//private List<String> medicines;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getDiseases() {
		return diseases;
	}

	public void setDiseases(String diseases) {
		this.diseases = diseases;
	}

	@Override
	public String toString() {
		return "PatientDetails [id=" + id + ", name=" + name + ", hospital=" + hospital + ", diseases=" + diseases
				+ "]";
	}

	public PatientDetailsEntity(Long id, String name, String hospital, String diseases) {
		super();
		this.id = id;
		this.name = name;
		this.hospital = hospital;
		this.diseases = diseases;
	}

	public PatientDetailsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

		

}
