package com.example.demo.services;

import com.example.demo.repository.ShipperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipperService {
    @Autowired
    private ShipperRepository shipperRepository;
    public void insertShipper(String name, String phone){
        shipperRepository.insertShipper(name, phone);
    }
}
