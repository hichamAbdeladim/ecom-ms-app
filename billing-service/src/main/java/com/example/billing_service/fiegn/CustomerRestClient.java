package com.example.billing_service.fiegn;

import com.example.billing_service.model.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "customer-service")
public interface CustomerRestClient {
    @GetMapping("/api/customer/{id}")
    @CircuitBreaker(name = "getCustomer", fallbackMethod = "getDefultCustomer")
    Customer getCustomerById(@PathVariable Long id);
    default Customer getDefultCustomer(Long id, Exception e){
        e.printStackTrace();
        Customer customer = new Customer();
        customer.setName("Default Customer name");
        customer.setEmail("Default Customer email");
        customer.setId(id);
        return customer;
    };

    @GetMapping("/api/customers")
    List<Customer> getAllCustomers();
}
