package com.abbadi.arstore.order.service;

import com.abbadi.arstore.item.parent.ItemRepositoryMapper;
import com.abbadi.arstore.order.model.OrderItem;
import com.abbadi.arstore.order.model.OrderItemDto;
import com.abbadi.arstore.order.model.OrderItemId;
import com.abbadi.arstore.order.model.OrderItemIdDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class OrderItemRepositoryMapper {

    private final ItemRepositoryMapper itemRepositoryMapper;

    public OrderItemDto toDto(OrderItem entity) {
        return OrderItemDto.builder()
                .id(OrderItemIdDto.builder()
                        .itemId(Optional.ofNullable(entity.getId())
                                .map(OrderItemId::getItemId)
                                .orElse(null))
                        .orderId(Optional.ofNullable(entity.getId())
                                .map(OrderItemId::getOrderId)
                                .orElse(null))
                        .build())
                .quantity(entity.getQuantity())
                .pricePerPiece(entity.getPricePerPiece())
                .itemDto(itemRepositoryMapper.toDto(entity.getItem()))
                .build();
    }

    public OrderItem toEntity(OrderItemDto dto) {
        return OrderItem.builder()
                .id(OrderItemId.builder()
                        .orderId(Optional.ofNullable(dto.getId())
                                .map(OrderItemIdDto::getOrderId)
                                .orElse(null))
                        .itemId(Optional.ofNullable(dto.getId())
                                .map(OrderItemIdDto::getItemId)
                                .orElse(null))
                        .build())
                .quantity(dto.getQuantity())
                .pricePerPiece(dto.getPricePerPiece())
                .item(itemRepositoryMapper.toEntity(dto.getItemDto()))
                .build();
    }
}
