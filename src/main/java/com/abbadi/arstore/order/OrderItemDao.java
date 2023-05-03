package com.abbadi.arstore.order;

import com.abbadi.arstore.order.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemDao extends JpaRepository<OrderItem, Long> {
}
