package com.abbadi.arstore.cartitem;

import com.abbadi.arstore.cartitem.model.CartItem;
import com.abbadi.arstore.cartitem.model.CartItemId;
import com.abbadi.arstore.item.parent.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface CartItemDao extends JpaRepository<CartItem, CartItemId> {

    @Query("SELECT i FROM CartItem i WHERE i.customer.id = :customerId")
    List<CartItem> findAllItemsByCustomerId(Long customerId);
}
