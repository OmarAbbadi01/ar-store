package com.abbadi.arstore.address.model;

import com.abbadi.arstore.common.generic.model.GenericRequest;
import com.abbadi.arstore.common.validation.OnCreate;
import com.abbadi.arstore.common.validation.OnUpdate;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Value;

import static com.abbadi.arstore.common.exception.ArStoreExceptionMessages.*;

@Value
public class AddressRequest implements GenericRequest<Long> {

    @NotNull(message = ID_CAN_NOT_BE_NULL, groups = OnUpdate.class)
    Long id;

    @NotNull(message = CAN_NOT_BE_NULL)
    @NotEmpty(message = CAN_NOT_BE_EMPTY)
    String country;

    @NotNull(message = CAN_NOT_BE_NULL)
    @NotEmpty(message = CAN_NOT_BE_EMPTY)
    String city;

    @NotNull(message = CAN_NOT_BE_NULL)
    @NotEmpty(message = CAN_NOT_BE_EMPTY)
    String street;

    @NotNull(message = CAN_NOT_BE_NULL)
    @NotEmpty(message = CAN_NOT_BE_EMPTY)
    String zip;

}
