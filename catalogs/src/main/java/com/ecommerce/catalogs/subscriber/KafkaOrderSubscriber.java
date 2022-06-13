package com.ecommerce.catalogs.subscriber;

import com.ecommerce.catalogs.domain.entity.Order;
import com.ecommerce.catalogs.service.CatalogsService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaOrderSubscriber {
    
    // 콜백 처리
    @Autowired
    CatalogsService service;
    
    @KafkaListener(topics = "msa", containerFactory = "orderConcurrentKafkaListenerContainerFactory")
    public void orderListener(Order order) {
        try {
            int cnt = service.updateQuantity(order);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    
        System.out.println(order.getProductId()+" 에 해당하는 상품 갯수가 " + order.getQuantity()+" 만큼 감소.");
    }
}
