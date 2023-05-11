package com.abbadi.arstore.order.model;

import com.abbadi.arstore.common.generic.model.GenericDto;
import com.abbadi.arstore.item.parent.model.ItemDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderItemDto implements GenericDto<OrderItemIdDto> {

    private OrderItemIdDto id;

    private Integer quantity;

    private Double pricePerPiece;

    private ItemDto itemDto;
}
