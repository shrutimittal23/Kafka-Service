package com.javainuse.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javainuse.dto.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
}
