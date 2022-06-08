package com.ecommerce.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.customer.domain.entity.Customer;
import com.ecommerce.customer.domain.repository.CustomerRepository;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public int insertCustomer(Customer customer) throws Exception {
		return customerRepository.insertCustomer(customer);
	}

	@Override
	public Customer selectCustomerByUserid(String userid) throws Exception {
		return customerRepository.selectCustomerByUserid(userid);
	}

	@Override
	public List<Customer> selectAllCustomer() throws Exception {
		return customerRepository.selectAllCustomer();
	}

	@Override
	public int existsCustomer(String userid) throws Exception {
		return customerRepository.existsCustomer(userid);
	}

	@Override
	public int deleteCustomer(String userid) throws Exception {
		return customerRepository.deleteCustomer(userid);
	}

	@Override
	public int updateCustomer(Customer customer) throws Exception {
		return customerRepository.updateCustomer(customer);
	}

}
