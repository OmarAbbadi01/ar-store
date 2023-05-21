package com.abbadi.arstore.order.model;

import com.abbadi.arstore.common.exception.ArStoreExceptionMessages;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class OrderItemRequest {

    @NotNull(message = ArStoreExceptionMessages.CAN_NOT_BE_NULL)
    Long itemId;

    @NotNull(message = ArStoreExceptionMessages.CAN_NOT_BE_NULL)
    @Min(value = 1, message = ArStoreExceptionMessages.FIELD_UNDER_MIN_VALUE)
    Integer quantity;
}
