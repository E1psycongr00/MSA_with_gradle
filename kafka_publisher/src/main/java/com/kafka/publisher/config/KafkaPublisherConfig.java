package com.kafka.publisher.config;

import com.kafka.publisher.domain.entity.Ping;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaPublisherConfig {
    
    @Bean
    public ProducerFactory<String, Ping> pingProducerFactory() {
        Map<String, Object> configProp = new HashMap<String, Object>();
        configProp.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        configProp.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProp.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<String, Ping>(configProp);
    }
    
    @Bean
    public KafkaTemplate<String, Ping> pingKafkaTemplate() {
        return new KafkaTemplate<String, Ping>(pingProducerFactory());
    }
}











