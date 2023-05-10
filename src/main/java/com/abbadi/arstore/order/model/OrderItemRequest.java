package com.abbadi.arstore.order.model;

import lombok.Value;

@Value
public class OrderItemRequest {

    Long itemId;

    Integer quantity;
}
