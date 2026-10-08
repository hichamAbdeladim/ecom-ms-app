package com.example.inventory_service.Controlers;

import com.example.inventory_service.entities.Product;
import com.example.inventory_service.reppsisory.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductControler {
    public final ProductRepository productRepository;
    public ProductControler(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    @GetMapping("/product/{id}")
    public Product findCustomerById(@PathVariable Long id){
        return productRepository.findById(id).get();
    }

    @GetMapping("/products")
    public List<Product> getCustomers(){
        return (List<Product>) this.productRepository.findAll();
    }
}
