package com.example.demo.repository;

import com.example.demo.dto.DeliveryDTO;
import com.example.demo.entities.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Integer> {
    @Modifying
    @Transactional
    @Query(value = "insert into Delivery(product_id, order_quantity, order_date, status) value(?,?,?)",nativeQuery = true)
    void insertDelivery(Integer product_id, Integer order_quantity, String order_date, String status);

    @Modifying
    @Transactional
    @Query(value = "update Delivery set status = 'Cancelled' where id=?1")
    void updateDeliveriesToCancelled(Integer id);

    @Modifying
    @Transactional
    @Query(value = "update Delivery set status = 'Waiting Confirmation' where id=?1")
    void updateDeliveriesToWaitingConfirmation(Integer id);

    @Modifying
    @Transactional
    @Query(value = "update Delivery set status = 'Delivered' where id=?1")
    void updateDeliveriesToDelivered(Integer id);

    @Query(value = "select * from Delivery where status=?",nativeQuery = true)
    Delivery deliveryStatus(String status);

    @Query("select new com.example.demo.dto.DeliveryDTO(p.name, d.orderQuantity, d.orderDate, d.status) from Product p join Delivery d on p.id = d.productId")
    List<DeliveryDTO>findDeliveryStatus();
}
