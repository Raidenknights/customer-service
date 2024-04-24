package com.example.practice.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.example.practice.entity.PatientDetailsEntity;

@Repository
public interface PatientRepository extends Neo4jRepository<PatientDetailsEntity, Long> {

}
