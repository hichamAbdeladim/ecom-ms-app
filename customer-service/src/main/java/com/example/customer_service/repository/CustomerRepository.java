package com.example.customer_service.repository;

import com.example.customer_service.entities.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource
public interface CustomerRepository extends CrudRepository<Customer,Long> {
}
