package com.abbadi.arstore.item.glasses.model;

import com.abbadi.arstore.common.Gender;
import com.abbadi.arstore.common.generic.model.GenericRequest;
import com.abbadi.arstore.common.validation.OnCreate;
import com.abbadi.arstore.common.validation.OnUpdate;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import static com.abbadi.arstore.common.exception.ArStoreExceptionMessages.*;

@Value
public class GlassesRequest implements GenericRequest<Long> {

    Long id;

    @NotNull(message = CAN_NOT_BE_NULL, groups = {OnUpdate.class, OnCreate.class})
    @NotEmpty(message = CAN_NOT_BE_EMPTY, groups = {OnUpdate.class, OnCreate.class})
    String description;

    @NotNull(message = CAN_NOT_BE_NULL, groups = {OnUpdate.class, OnCreate.class})
    Long storeId;

    @NotNull(message = CAN_NOT_BE_NULL, groups = {OnUpdate.class, OnCreate.class})
    Long brandId;

    @NotNull(message = CAN_NOT_BE_NULL, groups = {OnUpdate.class, OnCreate.class})
    @NotEmpty(message = CAN_NOT_BE_EMPTY, groups = {OnUpdate.class, OnCreate.class})
    String model;

    @NotNull(message = CAN_NOT_BE_NULL, groups = {OnUpdate.class, OnCreate.class})
    @NotEmpty(message = CAN_NOT_BE_EMPTY, groups = {OnUpdate.class, OnCreate.class})
    String color;

    @NotNull(message = CAN_NOT_BE_NULL, groups = {OnUpdate.class, OnCreate.class})
    @NotEmpty(message = CAN_NOT_BE_EMPTY, groups = {OnUpdate.class, OnCreate.class})
    String type;

    @NotNull(message = CAN_NOT_BE_NULL, groups = {OnUpdate.class, OnCreate.class})
    Gender gender;

    @NotNull(message = CAN_NOT_BE_NULL, groups = {OnUpdate.class, OnCreate.class})
    @Min(value = 0, message = FIELD_UNDER_MIN_VALUE, groups = {OnUpdate.class, OnCreate.class})
    Double price;

    @NotNull(message = CAN_NOT_BE_NULL, groups = {OnUpdate.class, OnCreate.class})
    @NotEmpty(message = CAN_NOT_BE_EMPTY, groups = {OnUpdate.class, OnCreate.class})
    String border;

    @NotNull(message = CAN_NOT_BE_NULL, groups = {OnUpdate.class, OnCreate.class})
    @NotEmpty(message = CAN_NOT_BE_EMPTY, groups = {OnUpdate.class, OnCreate.class})
    String shape;
}
