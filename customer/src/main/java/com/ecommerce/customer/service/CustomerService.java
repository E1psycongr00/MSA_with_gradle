package com.ecommerce.customer.service;

import java.util.List;

import com.ecommerce.customer.domain.entity.Customer;

public interface CustomerService {
	
	public int insertCustomer(Customer customer) throws Exception;
	public Customer selectCustomerByUserid(String userid) throws Exception;
	public List<Customer> selectAllCustomer() throws Exception;
	public int existsCustomer(String userid) throws Exception;
	public int deleteCustomer(String userid) throws Exception;
	public int updateCustomer(Customer customer) throws Exception;
	
}
