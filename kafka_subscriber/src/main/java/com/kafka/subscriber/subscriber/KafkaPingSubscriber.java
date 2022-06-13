package com.kafka.subscriber.subscriber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.kafka.subscriber.domain.entity.Ping;
import com.kafka.subscriber.service.KafkaSubscriberService;

@Component
public class KafkaPingSubscriber {

	//콜백으로 처리
	@Autowired
	KafkaSubscriberService service;
	
	@KafkaListener(topics = "msa", containerFactory = "pingConcurrentKafkaListenerContainerFactory")
	public void pingListener(Ping ping) {
		System.out.println("Ping 정보:" +  ping);
		//Service 연동
		service.response_ping();
	}
}
