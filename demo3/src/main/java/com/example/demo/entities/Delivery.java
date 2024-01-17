package com.example.demo.entities;

import lombok.Data;

import javax.lang.model.element.Name;
import javax.persistence.*;

@Entity
@Table
@Data
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "product_id")
    private int productId;
    @Column(name = "order_date")
    private String orderDate;//DD/MM/YYYY
    @Column(name = "order_quantity")
    private int orderQuantity;
    private String status;
}
