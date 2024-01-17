package com.example.demo.repository;

import com.example.demo.entities.Shipper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ShipperRepository extends JpaRepository<Shipper, Integer> {
    @Modifying
    @Transactional
    @Query(value = "insert into Shipper(name, phone) value(?,?)", nativeQuery = true)
    void insertShipper(String name, String phone);
}
