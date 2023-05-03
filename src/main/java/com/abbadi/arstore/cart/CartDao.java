package com.abbadi.arstore.cart;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartDao extends JpaRepository<Cart, Long> {
}
