package com.abbadi.arstore.cartitem.model;

import com.abbadi.arstore.common.generic.model.GenericResponse;
import com.abbadi.arstore.item.parent.model.ItemResponse;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CartItemResponse implements GenericResponse<CartItemId> {

    @JsonIgnore
    CartItemId id;

    ItemResponse item;

    Integer quantity;

}
