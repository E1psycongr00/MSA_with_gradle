package com.kafka.publisher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.publisher.domain.entity.Ping;
import com.kafka.publisher.service.KafkaPublisherService;

@RestController
public class KafkaPublisherController {

	
	@Autowired
	KafkaPublisherService service;
	
	@PostMapping("/publish")
	public String ping(@RequestBody  Ping ping) throws Exception{
		System.out.println(ping);
		return service.ping(ping);
	}
}
