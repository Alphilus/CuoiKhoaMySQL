package com.example.demo.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Shipper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String phone;
}
