package com.abbadi.arstore.item.parent.model;

import com.abbadi.arstore.common.generic.model.GenericRequest;
import com.abbadi.arstore.common.validation.OnCreate;
import com.abbadi.arstore.common.validation.OnUpdate;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.abbadi.arstore.common.exception.ArStoreExceptionMessages.*;


@AllArgsConstructor
@Getter
public class ItemRequest implements GenericRequest<Long> {

    @Null(groups = OnCreate.class, message = MUST_BE_NULL)
    @NotNull(groups = OnUpdate.class, message = CAN_NOT_BE_NULL)
    protected final Long id;

    @NotNull(message = CAN_NOT_BE_NULL, groups = {OnUpdate.class, OnCreate.class})
    @NotEmpty(message = CAN_NOT_BE_EMPTY, groups = {OnUpdate.class, OnCreate.class})
    protected final String description;

    @NotNull(message = CAN_NOT_BE_NULL, groups = {OnUpdate.class, OnCreate.class})
    @Min(value = 0, message = FIELD_UNDER_MIN_VALUE, groups = {OnUpdate.class, OnCreate.class})
    private final Double price;
}
