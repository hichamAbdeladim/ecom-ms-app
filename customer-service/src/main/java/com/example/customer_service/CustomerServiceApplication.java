package com.example.customer_service;

import com.example.customer_service.entities.Customer;
import com.example.customer_service.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

    @Bean
    CommandLineRunner start(CustomerRepository repository) {
        return args -> {
            repository.save(Customer.builder().name("mohamed").email("med@gamail.com").build());
            repository.save(Customer.builder().name("Imane").email("imane@gamail.com").build());
            repository.save(Customer.builder().name("Yassine").email("yassine@gamail.com").build());
        };
    }

}
