package com.abbadi.arstore.order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemDao extends JpaRepository<OrderItem, Long> {
}
