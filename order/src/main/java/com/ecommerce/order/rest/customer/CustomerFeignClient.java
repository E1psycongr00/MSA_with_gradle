package com.ecommerce.order.rest.customer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ecommerce-customer", url = "http://localhost:8076/ecommerce/customer")
public interface CustomerFeignClient {
    
    @GetMapping(value="/rest/customers/{userid}")
    public Customer retrieveCustomer(@PathVariable("userid") String userid) throws Exception;
    
}

