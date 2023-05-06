package com.abbadi.arstore.item.parent.model;

import com.abbadi.arstore.common.generic.model.GenericRequest;
import com.abbadi.arstore.common.validation.OnCreate;
import com.abbadi.arstore.common.validation.OnUpdate;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.abbadi.arstore.common.exception.ArStoreExceptionMessages.CAN_NOT_BE_EMPTY;
import static com.abbadi.arstore.common.exception.ArStoreExceptionMessages.CAN_NOT_BE_NULL;


@AllArgsConstructor
@Getter
public class ItemRequest implements GenericRequest<Long> {

    protected final Long id;

    @NotNull(message = CAN_NOT_BE_NULL, groups = {OnUpdate.class, OnCreate.class})
    @NotEmpty(message = CAN_NOT_BE_EMPTY, groups = {OnUpdate.class, OnCreate.class})
    protected final String description;
}
