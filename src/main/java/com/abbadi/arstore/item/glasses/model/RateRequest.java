package com.abbadi.arstore.item.glasses.model;

import com.abbadi.arstore.common.exception.ArStoreExceptionMessages;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class RateRequest {

    @NotNull(message = ArStoreExceptionMessages.CAN_NOT_BE_NULL)
    Long itemId;

    @NotNull(message = ArStoreExceptionMessages.CAN_NOT_BE_NULL)
    @Min(value = 0, message = ArStoreExceptionMessages.FIELD_UNDER_MIN_VALUE)
    @Max(value = 5, message = ArStoreExceptionMessages.FIELD_OVER_MAX_VALUE)
    Integer rating;
}
