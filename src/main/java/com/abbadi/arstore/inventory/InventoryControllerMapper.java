package com.abbadi.arstore.inventory;

import com.abbadi.arstore.common.generic.service.GenericControllerMapper;
import com.abbadi.arstore.inventory.model.InventoryItemDto;
import com.abbadi.arstore.inventory.model.InventoryItemId;
import com.abbadi.arstore.inventory.model.InventoryItemRequest;
import com.abbadi.arstore.inventory.model.InventoryItemResponse;
import com.abbadi.arstore.item.parent.ItemControllerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InventoryControllerMapper extends GenericControllerMapper<InventoryItemId, InventoryItemDto,
        InventoryItemRequest, InventoryItemResponse> {

    private final ItemControllerMapper itemControllerMapper;

    @Override
    protected InventoryItemDto mapToDto(InventoryItemRequest request) {
        return InventoryItemDto.builder()
                .id(request.getId())
                .quantity(request.getQuantity())
                .build();
    }

    @Override
    protected InventoryItemResponse mapToResponse(InventoryItemDto dto) {
        return InventoryItemResponse.builder()
                .id(dto.getId())
                .quantity(dto.getQuantity())
                .item(itemControllerMapper.toResponse(dto.getItemDto()))
                .build();
    }
}
