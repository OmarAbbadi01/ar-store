package com.abbadi.arstore.inventory;

import com.abbadi.arstore.common.generic.service.GenericRepository;
import com.abbadi.arstore.inventory.model.InventoryItemDto;
import com.abbadi.arstore.inventory.model.InventoryItemId;

import java.util.List;

public interface InventoryRepository extends GenericRepository<InventoryItemId, InventoryItemDto> {

    List<InventoryItemDto> findAllItemsInInventory(Long storeId);

    void deleteByStoreId(Long storeId);

}
