package com.abbadi.arstore.cartitem.model;

import com.abbadi.arstore.common.validation.OnCreate;
import com.abbadi.arstore.common.validation.OnUpdate;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import static com.abbadi.arstore.common.exception.ArStoreExceptionMessages.CAN_NOT_BE_NULL;
import static com.abbadi.arstore.common.exception.ArStoreExceptionMessages.FIELD_UNDER_MIN_VALUE;

@Value
public class CartItemRequest {

    @NotNull(message = CAN_NOT_BE_NULL, groups = {OnUpdate.class, OnCreate.class})
    Long itemId;

    @NotNull(message = CAN_NOT_BE_NULL, groups = {OnUpdate.class, OnCreate.class})
    Long customerId;

    @NotNull(message = CAN_NOT_BE_NULL, groups = {OnUpdate.class, OnCreate.class})
    @Min(value = 1, message = FIELD_UNDER_MIN_VALUE, groups = {OnUpdate.class, OnCreate.class})
    Integer quantity;

    public CartItemId getId() {
        return CartItemId.builder()
                .itemId(itemId)
                .customerId(customerId)
                .build();
    }
}
