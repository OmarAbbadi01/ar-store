package com.abbadi.arstore.brand.model;

import com.abbadi.arstore.common.generic.model.GenericRequest;
import com.abbadi.arstore.common.validation.OnCreate;
import com.abbadi.arstore.common.validation.OnUpdate;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Value;

import static com.abbadi.arstore.common.exception.ArStoreExceptionMessages.*;

@Value
public class BrandRequest implements GenericRequest<Long> {

    @Null(groups = OnCreate.class, message = ID_MUST_BE_NULL)
    @NotNull(groups = OnUpdate.class, message = ID_CAN_NOT_BE_NULL)
    Long id;

    @NotNull(message = CAN_NOT_BE_NULL)
    @NotEmpty(message = CAN_NOT_BE_EMPTY)
    String name;

    @NotNull(message = CAN_NOT_BE_NULL)
    @NotEmpty(message = CAN_NOT_BE_EMPTY)
    String countryOfOrigin;

}
