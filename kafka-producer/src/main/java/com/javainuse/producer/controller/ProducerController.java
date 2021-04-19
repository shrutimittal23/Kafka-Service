package com.javainuse.producer.controller;

import com.google.gson.Gson;
import com.javainuse.producer.dto.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
public class ProducerController {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private Gson gson;

    @PostMapping("/produce")
    public ResponseEntity<String> postModelToKafka(@RequestBody Customer customer)
            throws InterruptedException, ExecutionException {
        ListenableFuture<SendResult<String, String>> result = kafkaTemplate.send("customer", gson.toJson(customer));
        return new ResponseEntity<>(result.get().getProducerRecord().value(), HttpStatus.OK);
    }
}
