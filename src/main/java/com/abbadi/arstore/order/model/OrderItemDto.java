package com.abbadi.arstore.order.model;

import com.abbadi.arstore.item.parent.model.ItemDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderItemDto {

    private Integer quantity;

    private Double price;

    private ItemDto itemDto;
}
