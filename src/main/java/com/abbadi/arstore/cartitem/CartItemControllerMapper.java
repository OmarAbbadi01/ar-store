package com.abbadi.arstore.cartitem;

import com.abbadi.arstore.cartitem.model.CartItemDto;
import com.abbadi.arstore.cartitem.model.CartItemRequest;
import com.abbadi.arstore.cartitem.model.CartItemResponse;
import com.abbadi.arstore.item.parent.ItemControllerMapper;
import lombok.RequiredArgsConstructor;

public class CartItemControllerMapper {

    public static CartItemDto toDto(CartItemRequest request) {
        return request != null ?
                CartItemDto.builder()
                        .id(request.getId())
                        .quantity(request.getQuantity())
                        .build() : null;
    }

    public static CartItemResponse toResponse(CartItemDto dto) {
        return dto != null ?
                CartItemResponse.builder()
                        .item(ItemControllerMapper.toResponse(dto.getItemDto()))
                        .quantity(dto.getQuantity())
                        .build() : null;
    }
}
