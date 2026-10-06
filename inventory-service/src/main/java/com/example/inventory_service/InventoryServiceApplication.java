package com.example.inventory_service;

import com.example.inventory_service.entities.Product;
import com.example.inventory_service.reppsisory.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository repository) {
        return args -> {
            repository.save(Product.builder().name("Computer").price(34000).quantity(12).build());
            repository.save(Product.builder().name("Printer").price(1200).quantity(10).build());
            repository.save(Product.builder().name("Smart Phone").price(11000).quantity(5).build());

        };
    }
}
