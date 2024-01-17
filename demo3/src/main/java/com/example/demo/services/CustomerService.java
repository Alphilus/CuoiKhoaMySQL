package com.example.demo.services;

import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public void insertCustomer(String name, String email, String phone){
        customerRepository.insertCustomer(name, email, phone);
    }
}
