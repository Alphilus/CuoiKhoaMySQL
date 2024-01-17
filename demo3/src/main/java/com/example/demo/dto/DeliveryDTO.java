package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryDTO {
    private String name;
    private int orderQuantity;
    private String orderDate;//DD/MM/YYYY
    private String status;
}
