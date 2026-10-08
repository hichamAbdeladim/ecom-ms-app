package com.example.billing_service.fiegn;

import com.example.billing_service.model.Customer;
import com.example.billing_service.model.Product;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "inventory-service")
public interface ProductRestClient {
    @GetMapping("/api/product/{id}")
    @CircuitBreaker(name = "CB-product", fallbackMethod = "getfefultPrudoct")
    Product getProductById(@PathVariable Long id);

    default Product getfefultPrudoct(Long id,Exception e) {
        e.printStackTrace();
        Product product = new Product();
        product.setId(id);
        return product;
    };
    @GetMapping("/api/products")
    List<Product> getAllProducts();
}
