package com.ecommerce.order.rest.customer;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ecommerce-customer"
//        url = "http://localhost:8076/ecommerce/customer"
)
public interface CustomerFeignClient {
    
    @GetMapping(value="ecommerce/customer/rest/customers/{userid}")
    public Customer retrieveCustomer(@PathVariable("userid") String userid) throws Exception;
    
}

@Component
class CustomerFeignClientFallbackFactory implements FallbackFactory<CustomerFeignClient> {
    
    @Override
    public CustomerFeignClient create(Throwable cause) {
        
        //익명 클래스
        CustomerFeignClient client = new CustomerFeignClient() {
            
            @Override
            public Customer retrieveCustomer(String userid) throws Exception {
                String mesg = "FeignClient Error:"+ userid+" 에 해당하는 고객정보 조회가 지연되고 있습니다. 나중에 다시 요청하세요";
                System.out.println(mesg);
                throw new Exception();
            }
        };
        
        
        return client;
    }
}