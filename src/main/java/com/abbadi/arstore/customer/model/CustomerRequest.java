package com.abbadi.arstore.customer.model;

import com.abbadi.arstore.common.Gender;
import com.abbadi.arstore.common.generic.model.GenericRequest;
import com.abbadi.arstore.common.validation.OnCreate;
import com.abbadi.arstore.common.validation.OnUpdate;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Value;
import lombok.With;

import static com.abbadi.arstore.common.exception.ArStoreExceptionMessages.*;

@Value
public class CustomerRequest implements GenericRequest<Long> {

    @Null
    @With
    Long id;

    @NotNull(message = CAN_NOT_BE_NULL)
    @NotEmpty(message = CAN_NOT_BE_EMPTY)
    String name;

    @NotNull(message = CAN_NOT_BE_NULL)
    @NotEmpty(message = CAN_NOT_BE_EMPTY)
    String phoneNumber;

    @NotNull(message = CAN_NOT_BE_NULL)
    Gender gender;

    @JsonIgnore
    public Long getId() {
        return id;
    }
}
