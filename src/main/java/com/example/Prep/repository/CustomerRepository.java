package com.example.Prep.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Prep.entity.CustomerEntity;

/**
 * This is the interface which extends JPA repository and allows spring-boot
 * application to database.
 * 
 * @author Manas Vishnoi
 */
@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

	CustomerEntity findByusername(String username);

	CustomerEntity findByemail(String email);

	CustomerEntity modifyCustomer(String customerId, CustomerEntity customerEntity);

}
