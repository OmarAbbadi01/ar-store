package com.abbadi.arstore.cart;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemDao extends JpaRepository<CartItem, Long> {
}
