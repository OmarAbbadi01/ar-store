package com.abbadi.arstore.order.model;

import com.abbadi.arstore.common.exception.ArStoreExceptionMessages;
import com.abbadi.arstore.common.generic.model.GenericRequest;
import com.abbadi.arstore.common.validation.OnCreate;
import com.abbadi.arstore.common.validation.OnUpdate;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Value;

import java.util.List;

@Value
public class OrderRequest implements GenericRequest<Long> {

    @Null(message = ArStoreExceptionMessages.MUST_BE_NULL, groups = OnCreate.class)
    @NotNull(message = ArStoreExceptionMessages.CAN_NOT_BE_NULL, groups = OnUpdate.class)
    Long id;

    @NotNull(message = ArStoreExceptionMessages.CAN_NOT_BE_NULL)
    @NotEmpty(message = ArStoreExceptionMessages.CAN_NOT_BE_EMPTY)
    List<OrderItemRequest> orderItems;

}
