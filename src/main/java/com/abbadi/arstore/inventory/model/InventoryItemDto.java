package com.abbadi.arstore.inventory.model;

import com.abbadi.arstore.common.generic.model.GenericDto;
import com.abbadi.arstore.item.parent.model.ItemDto;
import com.abbadi.arstore.store.model.StoreDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InventoryItemDto implements GenericDto<InventoryItemId> {

    private InventoryItemId id;

    private Integer quantity;

    private StoreDto storeDto;

    private ItemDto itemDto;
}
