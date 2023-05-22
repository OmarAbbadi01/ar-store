package com.abbadi.arstore.inventory;

import com.abbadi.arstore.inventory.model.InventoryItem;
import com.abbadi.arstore.inventory.model.InventoryItemId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InventoryDao extends JpaRepository<InventoryItem, InventoryItemId> {

    @Query("SELECT i from InventoryItem i WHERE i.id.storeId = :storeId ")
    List<InventoryItem> findAllItemsInInventory(Long storeId);
}
