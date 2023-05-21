package com.abbadi.arstore.cartitem.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Value;
import org.springframework.security.core.context.SecurityContextHolder;

import static com.abbadi.arstore.common.exception.ArStoreExceptionMessages.CAN_NOT_BE_NULL;
import static com.abbadi.arstore.common.exception.ArStoreExceptionMessages.FIELD_UNDER_MIN_VALUE;

@Value
public class CartItemRequest {

    @NotNull(message = CAN_NOT_BE_NULL)
    Long itemId;

    @NotNull(message = CAN_NOT_BE_NULL)
    @Min(value = 1, message = FIELD_UNDER_MIN_VALUE)
    Integer quantity;

    public CartItemId getId() {
        return CartItemId.builder()
                .itemId(itemId)
                .customerId((Long) SecurityContextHolder.getContext().getAuthentication().getDetails())
                .build();
    }
}
