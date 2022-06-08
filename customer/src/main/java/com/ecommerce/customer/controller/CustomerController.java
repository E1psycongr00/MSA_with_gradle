package com.ecommerce.customer.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.customer.domain.entity.Customer;
import com.ecommerce.customer.service.CustomerService;

import io.swagger.annotations.ApiOperation;

@RestController
public class CustomerController {

	
	@Autowired
	CustomerService customerService;
	
	//고객 전체 조회
	@ApiOperation(value = "고객 전체 조회", httpMethod = "GET", notes = "고객 전체 조회")
	@GetMapping("/rest/customers")
	public List<Customer> selectAllCustomer() throws Exception{
		return customerService.selectAllCustomer();
	}
	
	@ApiOperation(value = "고객존재여부", httpMethod = "GET", notes = "고객존재여부")
	@RequestMapping(value = "/rest/customers/{userid}/exists", method = RequestMethod.GET)
	public boolean existsCustomer(@PathVariable("userid") String userid) throws Exception{
		boolean result = false;
		if(customerService.existsCustomer(userid) > 0) {
			result = true;
		}
		return result;
	}
	@ApiOperation(value = "고객 등록", httpMethod = "POST", notes = "고객 등록")
	@PostMapping(value = "/rest/customer")
	public int insertCustomer(@RequestBody Customer customer) throws Exception{
		 customer.setUserid(UUID.randomUUID().toString());
		 return customerService.insertCustomer(customer);
	}
	
	@ApiOperation(value = "고객 조회", httpMethod = "GET", notes = "고객 조회")
	@GetMapping(value="/rest/customers/{userid}")
	public Customer selectCustomerByUserid(@PathVariable("userid") String userid) throws Exception{
		 return customerService.selectCustomerByUserid(userid);
	}
	
	@ApiOperation(value = "고객  삭제", httpMethod = "DELETE", notes = "고객 삭제")
	@DeleteMapping(value="/rest/customers/{userid}")
	public int deleteCustomer(@PathVariable("userid") String userid) throws Exception{
		return customerService.deleteCustomer(userid);
	}
	
	@ApiOperation(value = "고객 수정", httpMethod = "PUT", notes = "고객 수정")
	@PutMapping(value = "/rest/customer")
	public int updateCustomer(@RequestBody Customer customer) throws Exception{
		 return customerService.updateCustomer(customer);
	}
	
}
