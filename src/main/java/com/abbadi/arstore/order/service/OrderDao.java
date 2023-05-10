package com.abbadi.arstore.order.service;

import com.abbadi.arstore.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<Order, Long> {
}
