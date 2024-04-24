package com.example.practice.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.example.practice.entity.MedicineCreationEntity;

@Repository
public interface MedicineRepository extends Neo4jRepository<MedicineCreationEntity, Long> {

}
