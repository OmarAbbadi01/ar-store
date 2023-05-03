package com.abbadi.arstore.address.model;

import com.abbadi.arstore.common.generic.model.GenericRequest;
import com.abbadi.arstore.common.validation.OnCreate;
import com.abbadi.arstore.common.validation.OnUpdate;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import static com.abbadi.arstore.common.exception.ArStoreExceptionMessages.CAN_NOT_BE_EMPTY;
import static com.abbadi.arstore.common.exception.ArStoreExceptionMessages.CAN_NOT_BE_NULL;

@Value
public class AddressRequest implements GenericRequest<Long> {

    Long id;

    @NotNull(message = CAN_NOT_BE_NULL, groups = {OnUpdate.class, OnCreate.class})
    @NotEmpty(message = CAN_NOT_BE_EMPTY, groups = {OnUpdate.class, OnCreate.class})
    String country;

    @NotNull(message = CAN_NOT_BE_NULL, groups = {OnUpdate.class, OnCreate.class})
    @NotEmpty(message = CAN_NOT_BE_EMPTY, groups = {OnUpdate.class, OnCreate.class})
    String city;

    @NotNull(message = CAN_NOT_BE_NULL, groups = {OnUpdate.class, OnCreate.class})
    @NotEmpty(message = CAN_NOT_BE_EMPTY, groups = {OnUpdate.class, OnCreate.class})
    String street;

    @NotNull(message = CAN_NOT_BE_NULL, groups = {OnUpdate.class, OnCreate.class})
    @NotEmpty(message = CAN_NOT_BE_EMPTY, groups = {OnUpdate.class, OnCreate.class})
    String zip;

}
