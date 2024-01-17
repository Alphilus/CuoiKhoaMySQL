package com.example.demo.services;

import com.example.demo.dto.DeliveryDTO;
import com.example.demo.entities.Delivery;
import com.example.demo.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class DeliveryService {
    @Autowired
    private DeliveryRepository deliveryRepository;

    public void insertDelivery(Integer product_id ,Integer order_quantity, String order_date, String status){
        deliveryRepository.insertDelivery(product_id, order_quantity , order_date, status);
    }

    public void deliveryStatus(String status){
        Delivery delivery = deliveryRepository.deliveryStatus(status);
        if (delivery!=null)
            System.out.println(delivery);
        else System.out.println("Error");
    }

    public void findDeliveryStatus(){
        List<DeliveryDTO> deliveryDTOS =deliveryRepository.findDeliveryStatus();
        System.out.println("======================================");
        System.out.println(deliveryDTOS);
    }

    public void updateDeliveriesToDelivered(){
        System.out.println("Select the id of the delivery that you want to update: ");
        int id = Integer.parseInt(new Scanner(System.in).nextLine());
        deliveryRepository.updateDeliveriesToDelivered(id);
    }

    public void updateDeliveriesToWaitingConfirmation(){
        System.out.println("Select the id of the delivery that you want to update: ");
        int id = Integer.parseInt(new Scanner(System.in).nextLine());
        deliveryRepository.updateDeliveriesToWaitingConfirmation(id);
    }

    public void updateDeliveriesToCancelled(){
        System.out.println("Select the id of the delivery that you want to update: ");
        int id = Integer.parseInt(new Scanner(System.in).nextLine());
        deliveryRepository.updateDeliveriesToCancelled(id);
    }
}
