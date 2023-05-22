package com.abbadi.arstore.inventory;

import com.abbadi.arstore.common.generic.service.GenericRepositoryMapper;
import com.abbadi.arstore.inventory.model.InventoryItem;
import com.abbadi.arstore.inventory.model.InventoryItemDto;
import com.abbadi.arstore.inventory.model.InventoryItemId;
import com.abbadi.arstore.item.parent.ItemRepositoryMapper;
import com.abbadi.arstore.store.StoreRepositoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InventoryRepositoryMapper extends GenericRepositoryMapper<InventoryItemId, InventoryItem, InventoryItemDto> {

    private final ItemRepositoryMapper itemRepositoryMapper;

    private final StoreRepositoryMapper storeRepositoryMapper;

    @Override
    protected InventoryItemDto mapToDto(InventoryItem entity) {
        return InventoryItemDto.builder()
                .id(entity.getId())
                .quantity(entity.getQuantity())
                .itemDto(itemRepositoryMapper.toDto(entity.getItem()))
                .storeDto(storeRepositoryMapper.toDto(entity.getStore()))
                .build();
    }

    @Override
    protected InventoryItem mapToEntity(InventoryItemDto dto) {
        return InventoryItem.builder()
                .id(dto.getId())
                .quantity(dto.getQuantity())
                .item(itemRepositoryMapper.toEntity(dto.getItemDto()))
                .store(storeRepositoryMapper.toEntity(dto.getStoreDto()))
                .build();
    }

}
