package com.abbadi.arstore.order.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class OrderItemIdDto implements Serializable {

    private Long itemId;

    private Long orderId;

}
