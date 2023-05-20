package com.abbadi.arstore.order.model;

import com.abbadi.arstore.item.parent.model.ItemResponse;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class OrderItemResponse {
    Integer quantity;

    Double price;

    ItemResponse item;

}
