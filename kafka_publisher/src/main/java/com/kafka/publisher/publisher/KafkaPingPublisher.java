package com.kafka.publisher.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.kafka.publisher.domain.entity.Ping;

// Kafka에  Ping 객체를 publish 역할 담당

@Component
public class KafkaPingPublisher {

	@Autowired
	KafkaTemplate<String, Ping>  pingKafkaTemplate;
	
	
	public String ping(Ping ping) throws Exception{
		pingKafkaTemplate.send("msa", ping); // (topic명, 객체)
		
		return "publish 성공";
	}
}
