package com.kafka.subscriber.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.subscriber.domain.entity.Ping;
import com.kafka.subscriber.service.KafkaSubscriberService;

@RestController
public class KafkaSubscriberController {

	@Autowired
	KafkaSubscriberService service;
	
	@GetMapping("/subscribe")
	public String  exam() {
		Ping ping = service.response_ping();
		
		return "Hello";
	}
}
