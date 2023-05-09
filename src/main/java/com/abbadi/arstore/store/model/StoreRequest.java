package com.abbadi.arstore.store.model;

import com.abbadi.arstore.common.generic.model.GenericRequest;
import com.abbadi.arstore.common.validation.OnCreate;
import com.abbadi.arstore.common.validation.OnUpdate;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Value;

import static com.abbadi.arstore.common.exception.ArStoreExceptionMessages.*;

@Value
public class StoreRequest implements GenericRequest<Long> {

    @Null(groups = OnCreate.class, message = MUST_BE_NULL)
    @NotNull(groups = OnUpdate.class, message = CAN_NOT_BE_NULL)
    Long id;

    @NotNull(message = CAN_NOT_BE_NULL, groups = {OnUpdate.class, OnCreate.class})
    @NotEmpty(message = CAN_NOT_BE_EMPTY, groups = {OnUpdate.class, OnCreate.class})
    String name;

    @NotNull(message = CAN_NOT_BE_NULL, groups = {OnUpdate.class, OnCreate.class})
    @NotEmpty(message = CAN_NOT_BE_EMPTY, groups = {OnUpdate.class, OnCreate.class})
    String phoneNumber;

}
