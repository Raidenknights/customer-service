package com.example.Prep.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Prep.entity.CustomerEntity;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity,String>{
	
	CustomerEntity findByusername(String username);
	CustomerEntity findByemail(String email);

	
}
