package com.abbadi.arstore.store.model;

import com.abbadi.arstore.common.generic.model.GenericRequest;
import com.abbadi.arstore.common.validation.OnCreate;
import com.abbadi.arstore.common.validation.OnUpdate;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Value;
import org.springframework.security.core.context.SecurityContextHolder;

import static com.abbadi.arstore.common.exception.ArStoreExceptionMessages.*;

@Value
public class StoreRequest implements GenericRequest<Long> {

    Long id = (Long) SecurityContextHolder.getContext().getAuthentication().getDetails();

    @NotNull(message = CAN_NOT_BE_NULL)
    @NotEmpty(message = CAN_NOT_BE_EMPTY)
    String name;

    @NotNull(message = CAN_NOT_BE_NULL)
    @NotEmpty(message = CAN_NOT_BE_EMPTY)
    String phoneNumber;

    @JsonIgnore
    public Long getId() {
        return id;
    }
}
