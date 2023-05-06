package com.abbadi.arstore.cartitem;

import com.abbadi.arstore.cartitem.model.CartItemDto;
import com.abbadi.arstore.cartitem.model.CartItemId;
import com.abbadi.arstore.common.generic.service.GenericRepository;

import java.util.List;

public interface CartItemRepository extends GenericRepository<CartItemId, CartItemDto> {

    List<CartItemDto> findAllItemsInCart(Long customerId);
}
