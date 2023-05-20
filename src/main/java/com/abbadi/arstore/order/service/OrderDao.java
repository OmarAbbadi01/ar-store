package com.abbadi.arstore.order.service;

import com.abbadi.arstore.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderDao extends JpaRepository<Order, Long> {

    @Query("SELECT sum(oi.pricePerPiece * oi.quantity) " +
            "FROM Order o INNER JOIN o.ordersItems oi " +
            "WHERE o.id = :orderId")
    Double getOrderTotalPrice(Long orderId);

    List<Order> findAllByCustomerId(Long customer);

}
