package com.ecommerce.order.service;

import java.util.List;

import com.ecommerce.order.domain.entity.Order;

public interface OrderService {

	public List<Order> selectOrderByUserId(String userid) throws Exception;

	public int insertOrder(Order order) throws Exception;
	
	public int insertOrderFeign(Order order) throws Exception;
}
