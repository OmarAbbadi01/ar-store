package com.abbadi.arstore.cart;

import com.abbadi.arstore.cart.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemDao extends JpaRepository<CartItem, Long> {
}
