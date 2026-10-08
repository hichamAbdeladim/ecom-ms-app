package com.example.customer_service.controlers;

import com.example.customer_service.entities.Customer;
import com.example.customer_service.repository.CustomerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class customerControler {
    public final CustomerRepository customerRepository;
    public customerControler(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }

    @GetMapping("/customer/{id}")
    public Customer findCustomerById(@PathVariable Long id){
        return customerRepository.findById(id).get();
    }
    @GetMapping("/customers")
    public List<Customer> getCustomers(){
        return (List<Customer>) this.customerRepository.findAll();
    }
}
