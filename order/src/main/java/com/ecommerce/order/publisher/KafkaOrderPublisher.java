package com.ecommerce.order.publisher;

import com.ecommerce.order.domain.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
public class KafkaOrderPublisher {
    
    @Autowired
    KafkaTemplate<String, Order> orderKafkaTemplate;
    
    public void insertOrder(Order order) throws Exception {
        ListenableFuture<SendResult<String, Order>> future = orderKafkaTemplate.send("msa", order);
        
        future.addCallback(new ListenableFutureCallback<SendResult<String, Order>>() {
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("unable send Message");
            }
    
            @Override
            public void onSuccess(SendResult<String, Order> result) {
                Order order1 = result.getProducerRecord().value();
                System.out.println("send Message: " + order.toString()
                        + ", offset:" + result.getRecordMetadata().offset());
            }
        });
    }
}
