package com.example.customer_service.controlers;

import com.example.customer_service.config.GlobalConfig;
import com.example.customer_service.entities.Customer;
import com.example.customer_service.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RefreshScope
@RestController
@RequestMapping("/api")
public class customerControler {
    public final CustomerRepository customerRepository;
    public customerControler(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }

    @Value("${titre}")
    private String titre;

    @Autowired
    public GlobalConfig globalConfig;
    @GetMapping("/config")
    public String titre() {
        return titre;
    }

    @GetMapping("/globalConfig")
    public GlobalConfig globalConfig() {
        return globalConfig;
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
