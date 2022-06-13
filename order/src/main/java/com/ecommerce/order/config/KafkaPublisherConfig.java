package com.ecommerce.order.config;


import com.ecommerce.order.domain.entity.Order;
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
    public ProducerFactory<String, Order> orderProducerFactory() {
        Map<String, Object> configProp = new HashMap<String, Object>();
        configProp.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        configProp.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProp.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<String, Order>(configProp);
    }
    
    
    @Bean
    public KafkaTemplate<String, Order> pingKafkaTemplate() {
        return new KafkaTemplate<String, Order>(orderProducerFactory());
    }
}
