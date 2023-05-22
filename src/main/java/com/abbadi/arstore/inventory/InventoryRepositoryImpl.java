package com.abbadi.arstore.inventory;

import com.abbadi.arstore.common.generic.service.GenericRepositoryImpl;
import com.abbadi.arstore.inventory.model.InventoryItem;
import com.abbadi.arstore.inventory.model.InventoryItemDto;
import com.abbadi.arstore.inventory.model.InventoryItemId;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class InventoryRepositoryImpl extends GenericRepositoryImpl<InventoryItemId, InventoryItem, InventoryItemDto>
        implements InventoryRepository {

    private final InventoryDao dao;

    private final InventoryRepositoryMapper mapper;

    public InventoryRepositoryImpl(InventoryDao dao, InventoryRepositoryMapper mapper) {
        super(dao, mapper);
        this.dao = dao;
        this.mapper = mapper;
    }

    @Transactional(readOnly = true)
    @Override
    public List<InventoryItemDto> findAllItemsInInventory(Long storeId) {
        return dao.findAllItemsInInventory(storeId)
                .stream()
                .map(mapper::toDto)
                .toList();
    }
}
