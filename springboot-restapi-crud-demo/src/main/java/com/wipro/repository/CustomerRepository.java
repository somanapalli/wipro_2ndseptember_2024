package com.wipro.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.wipro.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

	Optional<Customer> findByEmail(String email);
}
