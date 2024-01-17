package com.example.demo.repository;

import com.example.demo.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    @Modifying
    @Transactional
    @Query(value = "insert into Customer(name, email, phone) value(?,?,?)", nativeQuery = true)
    void insertCustomer(String name, String email, String phone);
}
