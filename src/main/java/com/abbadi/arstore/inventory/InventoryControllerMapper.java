package com.abbadi.arstore.inventory;

import com.abbadi.arstore.inventory.model.InventoryItemDto;
import com.abbadi.arstore.inventory.model.InventoryItemRequest;
import com.abbadi.arstore.inventory.model.InventoryItemResponse;
import com.abbadi.arstore.item.parent.ItemControllerMapper;

public class InventoryControllerMapper {

    public static InventoryItemDto toDto(InventoryItemRequest request) {
        return request != null ?
                InventoryItemDto.builder()
                        .id(request.getId())
                        .quantity(request.getQuantity())
                        .build() : null;
    }

    public static InventoryItemResponse toResponse(InventoryItemDto dto) {
        return dto != null ?
                InventoryItemResponse.builder()
                        .id(dto.getId())
                        .quantity(dto.getQuantity())
                        .item(ItemControllerMapper.toResponse(dto.getItemDto()))
                        .build() : null;
    }

}
