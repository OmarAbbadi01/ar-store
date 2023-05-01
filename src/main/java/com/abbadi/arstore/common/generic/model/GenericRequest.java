package com.abbadi.arstore.common.generic.model;

import com.abbadi.arstore.common.validation.OnCreate;
import com.abbadi.arstore.common.validation.OnUpdate;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;

import java.io.Serializable;

import static com.abbadi.arstore.common.exception.ArStoreExceptionMessages.CAN_NOT_BE_NULL;
import static com.abbadi.arstore.common.exception.ArStoreExceptionMessages.MUST_BE_NULL;

public interface GenericRequest<Id extends Serializable> {

    @Null(groups = OnCreate.class, message = MUST_BE_NULL)
    @NotNull(groups = OnUpdate.class, message = CAN_NOT_BE_NULL)
    Id getId();

}
