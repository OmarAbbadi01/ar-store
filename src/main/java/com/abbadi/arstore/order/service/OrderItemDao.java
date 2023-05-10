package com.abbadi.arstore.order.service;

import com.abbadi.arstore.order.model.OrderItem;
import com.abbadi.arstore.order.model.OrderItemId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemDao extends JpaRepository<OrderItem, OrderItemId> {
}
