package com.abbadi.arstore.inventory.model;

import com.abbadi.arstore.common.generic.model.GenericResponse;
import com.abbadi.arstore.item.parent.model.ItemResponse;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class InventoryItemResponse implements GenericResponse<InventoryItemId> {

    @JsonIgnore
    InventoryItemId id;

    Integer quantity;

    ItemResponse item;
}
