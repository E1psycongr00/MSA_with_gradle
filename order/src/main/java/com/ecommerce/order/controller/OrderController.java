package com.ecommerce.order.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.order.domain.entity.Order;
import com.ecommerce.order.service.OrderService;

import io.swagger.annotations.ApiOperation;

@RestController
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@ApiOperation(value = "주문 조회", httpMethod = "GET", notes = "주문 조회")
	@GetMapping(value="/rest/orders/{userid}")
	public List<Order> selectOrderByUserId(@PathVariable("userid") String userid) throws Exception{
		return orderService.selectOrderByUserId(userid);
	}
	
	@ApiOperation(value = "주문 등록", httpMethod = "POST", notes = "주문 등록")
	@PostMapping(value="/insertOrder")
	public int insertOrder(@RequestBody Order order) throws Exception{
		order.setOrderId(UUID.randomUUID().toString());
		return orderService.insertOrder(order);
	}
}






