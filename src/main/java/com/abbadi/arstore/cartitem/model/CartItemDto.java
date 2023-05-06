package com.abbadi.arstore.cartitem.model;

import com.abbadi.arstore.common.generic.model.GenericDto;
import com.abbadi.arstore.customer.model.CustomerDto;
import com.abbadi.arstore.item.parent.model.ItemDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CartItemDto implements GenericDto<CartItemId> {

    CartItemId id;

    Integer quantity;

    CustomerDto customerDto;

    ItemDto itemDto;

}
