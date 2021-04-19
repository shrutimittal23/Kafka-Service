package com.javainuse.service;

import com.google.gson.Gson;
import com.javainuse.dto.Customer;
import com.javainuse.repo.CustomerRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

	@Autowired
	private Gson gson;
	@Autowired
	private CustomerRepo customerRepo;
	Customer newCustomer = new Customer();

	@KafkaListener(topics = "customer")
	public void getTopics(String customer) {

		System.out.println("Kafka event consumed is: " + customer);
		newCustomer = gson.fromJson(customer, Customer.class);
		System.out.println("Model converted value: " + customer.toString());
		customerRepo.save(newCustomer);

	}

}