package com.kafka.publisher.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kafka.publisher.domain.entity.Ping;
import com.kafka.publisher.publisher.KafkaPingPublisher;

@Service
public class KafkaPublisherServiceImpl implements KafkaPublisherService {

	@Autowired
	KafkaPingPublisher publisher;
	
	
	@Override
	public String ping(Ping ping) throws Exception {
		//Kafka 서버에 Ping 객체를  전송하는 코드 
		return publisher.ping(ping);
	}

}
