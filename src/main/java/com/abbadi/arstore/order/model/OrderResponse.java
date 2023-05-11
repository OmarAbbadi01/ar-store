package com.abbadi.arstore.order.model;

import com.abbadi.arstore.common.generic.model.GenericResponse;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class OrderResponse implements GenericResponse<Long> {

    Long id;

    OrderStatus orderStatus;

    Double discount;

    Double totalPrice;

    List<OrderItemResponse> orderItemResponses;
}
