package com.acme.homehealthy.Initialization.domain.service;

import com.acme.homehealthy.Initialization.domain.model.Customer;
import org.springframework.http.ResponseEntity;

public interface CustomerService {
    Customer getCustomerById(Long id);
    Customer getCustomerByUsernameAndPassword(String username, String password);
    Customer createCustomer(Customer customer);
    Customer updateCustomer(Long id, Customer customer);
    ResponseEntity<?> deleteCustomer(String username);
}
