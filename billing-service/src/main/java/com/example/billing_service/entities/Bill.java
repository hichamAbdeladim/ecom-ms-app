package com.example.billing_service.entities;

import com.example.billing_service.model.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Bill {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date billigDate;
    private Long customerId;
    @OneToMany(mappedBy = "bill")
    private List<ProductItem> items;
    @Transient
    private Customer customer;
}
