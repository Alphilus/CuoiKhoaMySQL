package com.example.demo.services;

import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public void insertProduct(String name, Integer quantity, Integer price){
        productRepository.insertProduct(name, quantity, price);
    }
}
