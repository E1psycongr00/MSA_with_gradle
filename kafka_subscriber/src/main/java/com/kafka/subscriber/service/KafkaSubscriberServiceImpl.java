package com.kafka.subscriber.service;

import org.springframework.stereotype.Service;

import com.kafka.subscriber.domain.entity.Ping;

@Service
public class KafkaSubscriberServiceImpl implements KafkaSubscriberService {

	@Override
	public Ping response_ping() {
		System.out.println("KafkaSubscriberServiceImpl>>>");
		return null;
	}

}
