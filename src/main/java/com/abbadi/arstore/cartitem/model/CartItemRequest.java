package com.abbadi.arstore.cartitem.model;

import com.abbadi.arstore.common.generic.model.GenericRequest;
import lombok.Value;

@Value
public class CartItemRequest implements GenericRequest<CartItemId> {

    Long itemId;

    Long customerId;

    Integer quantity;

    @Override
    public CartItemId getId() {
        return CartItemId.builder()
                .itemId(itemId)
                .customerId(customerId)
                .build();
    }
}
