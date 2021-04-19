package com.javainuse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javainuse.dto.Customer;
import com.javainuse.repo.CustomerRepo;

import java.util.List;

@RestController
public class CustomerController {
	@Autowired
	private CustomerRepo customerRepo;

	@GetMapping("/all")
	public List<Customer> getAll() {
		return customerRepo.findAll();
	}
}
