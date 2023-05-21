package com.abbadi.arstore.item.glasses.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class RateRequest {

    @NotNull
    Long itemId;

    @NotNull
    @Min(value = 0)
    @Max(value = 5)
    Integer rating;
}
