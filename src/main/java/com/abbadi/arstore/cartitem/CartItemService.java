package com.abbadi.arstore.cartitem;

import com.abbadi.arstore.cartitem.model.CartItemDto;
import com.abbadi.arstore.cartitem.model.CartItemId;

import java.util.List;

public interface CartItemService {

    List<CartItemDto> findAll(Long customerId);

    void delete(CartItemId id); // TODO: to be refactored to itemId only

    void update(CartItemDto dto);

    CartItemId create(CartItemDto dto);

}
