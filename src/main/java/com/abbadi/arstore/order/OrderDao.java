package com.abbadi.arstore.order;

import com.abbadi.arstore.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<Order, Long> {
}
