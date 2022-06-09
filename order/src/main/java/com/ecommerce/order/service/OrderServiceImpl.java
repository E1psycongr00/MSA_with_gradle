package com.ecommerce.order.service;

import java.util.List;

import com.ecommerce.order.rest.customer.CustomerFeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
	@HystrixCommand(fallbackMethod = "insertOrderFallback", commandKey = "retrieveCustomer")
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
	
	public int insertOrderFallback(Order order) throws Exception {
		// 서킷 브레이커 동작시 해야 되는 추가 작업 구현
		String mesg = "Error:"+ order.getUserId()+" 에 해당하는 고객정보 조회가 지연되고 있습니다. 나중에 다시 요청하세요";
		System.out.println(mesg);
		throw new Exception();
	}
}







