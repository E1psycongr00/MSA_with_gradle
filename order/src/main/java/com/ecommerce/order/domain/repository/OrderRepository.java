package com.ecommerce.order.domain.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ecommerce.order.domain.entity.Order;

@Mapper
public interface OrderRepository {

	public List<Order> selectOrderByUserId(String userid) throws Exception;

	public int insertOrder(Order order)throws Exception;
	
}
