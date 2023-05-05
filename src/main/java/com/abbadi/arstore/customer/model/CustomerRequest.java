package com.abbadi.arstore.customer.model;

import com.abbadi.arstore.common.Gender;
import com.abbadi.arstore.common.generic.model.GenericRequest;
import com.abbadi.arstore.common.validation.OnCreate;
import com.abbadi.arstore.common.validation.OnUpdate;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import static com.abbadi.arstore.common.exception.ArStoreExceptionMessages.CAN_NOT_BE_EMPTY;
import static com.abbadi.arstore.common.exception.ArStoreExceptionMessages.CAN_NOT_BE_NULL;

@Value
public class CustomerRequest implements GenericRequest<Long> {

    Long id;

    @NotNull(message = CAN_NOT_BE_NULL, groups = {OnUpdate.class, OnCreate.class})
    @NotEmpty(message = CAN_NOT_BE_EMPTY, groups = {OnUpdate.class, OnCreate.class})
    String name;

    @NotNull(message = CAN_NOT_BE_NULL, groups = {OnUpdate.class, OnCreate.class})
    @NotEmpty(message = CAN_NOT_BE_EMPTY, groups = {OnUpdate.class, OnCreate.class})
    String phoneNumber;

    @NotNull(message = CAN_NOT_BE_NULL, groups = {OnUpdate.class, OnCreate.class})
    Gender gender;
}
