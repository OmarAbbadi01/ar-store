package com.abbadi.arstore.inventory;

import com.abbadi.arstore.inventory.model.InventoryItemDto;
import com.abbadi.arstore.inventory.model.InventoryItemId;

import java.util.List;

public interface InventoryService {

    List<InventoryItemDto> findAll(Long storeId);

    void delete(InventoryItemId id);

    void update(InventoryItemDto dto);

    InventoryItemId create(InventoryItemDto dto);
}
