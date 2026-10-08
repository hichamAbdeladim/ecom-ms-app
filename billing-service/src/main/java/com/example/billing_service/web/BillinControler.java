package com.example.billing_service.web;

import com.example.billing_service.entities.Bill;
import com.example.billing_service.fiegn.CustomerRestClient;
import com.example.billing_service.fiegn.ProductRestClient;
import com.example.billing_service.repository.BillRepository;
import com.example.billing_service.repository.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BillinControler {
    @Autowired
    BillRepository billRepository;
    @Autowired
    ProductItemRepository productItemRepository;
    @Autowired
    CustomerRestClient customerRestClient;
    @Autowired
    ProductRestClient productRestClient;
    @GetMapping("bills/{id}")
    public Bill getBillinById(@PathVariable Long id){
        Bill bill = billRepository.findById(id).get();
        bill.getItems().forEach(item -> {
            item.setProduct(productRestClient.getProductById(item.getProductID()));
        });
        bill.setCustomer(customerRestClient.getCustomerById(bill.getCustomerId()));
        return bill;
    }
}
