package com.kafka.subscriber.config;

import com.kafka.subscriber.domain.entity.Ping;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaSubscriberConfig {
    
    @Bean
    public ConsumerFactory<String, Ping> pingConsumerFactory() {
        Map<String, Object> configProp = new HashMap<String, Object>();
        configProp.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        configProp.put(ConsumerConfig.GROUP_ID_CONFIG, "ping");
        configProp.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configProp.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        // 반드시 다음과 같이 코드 작성할 것.
        return new DefaultKafkaConsumerFactory<>(configProp, new StringDeserializer(),
                new JsonDeserializer<>(Ping.class, false));
        
    }
    
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Ping> pingConcurrentKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Ping> xxx = new ConcurrentKafkaListenerContainerFactory<String, Ping>();
        xxx.setConsumerFactory(pingConsumerFactory());
        
        return xxx;
    }
    
}








