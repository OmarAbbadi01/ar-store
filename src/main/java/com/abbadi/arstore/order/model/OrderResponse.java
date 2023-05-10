package com.abbadi.arstore.order.model;

import com.abbadi.arstore.common.generic.model.GenericResponse;
import com.abbadi.arstore.item.parent.model.ItemResponse;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class OrderResponse implements GenericResponse<Long> {

    Long id;

    OrderStatus orderStatus;

    Double discount;

    List<ItemResponse> itemsResponse;
}
