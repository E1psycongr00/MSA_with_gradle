package com.ecommerce.order.service;

import java.util.List;

import com.ecommerce.order.rest.customer.CustomerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ecommerce.order.domain.entity.Order;
import com.ecommerce.order.domain.repository.OrderRepository;
import com.ecommerce.order.rest.customer.Customer;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	@Value("${customer.api.url}")
	String customer_api_url;
	
	//RestTemplate 생성
	@Bean  // @Bean으로 지정하면 자동으로 메서드 호출됨
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Autowired  // @Bean에서 생성된 RestTemplate을 주입받는다. 
	RestTemplate restTemplate;
	
	@Autowired
	CustomerFeignClient customerFeignClient;
	
	@Override
	public List<Order> selectOrderByUserId(String userid) throws Exception {
		return orderRepository.selectOrderByUserId(userid);
	}

	@Override
	public int insertOrder(Order order) throws Exception {
		// Order안에 고객명이 누락된 상태이다.
		String url = customer_api_url+"/rest/customers/"+order.getUserId();
		Customer cust = restTemplate.getForObject(url, Customer.class);
		order.setName(cust.getName());
		
		return orderRepository.insertOrder(order);
	}
	
	@Override
	public int insertOrderFeign(Order order) throws Exception {
		Customer cust = customerFeignClient.retrieveCustomer(order.getUserId());
		order.setName(cust.getName());
		
		return orderRepository.insertOrder(order);
	}
}







