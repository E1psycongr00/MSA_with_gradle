package com.kafka.publisher.service;

import com.kafka.publisher.domain.entity.Ping;

public interface KafkaPublisherService {

	public String ping(Ping ping) throws Exception;
}
