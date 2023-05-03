package com.abbadi.arstore.cart;

import com.abbadi.arstore.cart.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartDao extends JpaRepository<Cart, Long> {
}
