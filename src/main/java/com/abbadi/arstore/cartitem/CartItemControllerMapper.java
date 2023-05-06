package com.abbadi.arstore.cartitem;

import com.abbadi.arstore.cartitem.model.CartItemDto;
import com.abbadi.arstore.cartitem.model.CartItemRequest;
import com.abbadi.arstore.cartitem.model.CartItemResponse;
import com.abbadi.arstore.item.parent.ItemControllerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CartItemControllerMapper {

    private final ItemControllerMapper itemControllerMapper;

    public CartItemDto toDto(CartItemRequest request) {
        return request != null ? mapToDto(request) : null;
    }

    public CartItemResponse toResponse(CartItemDto dto) {
        return dto != null ? mapToResponse(dto) : null;
    }

    private CartItemDto mapToDto(CartItemRequest request) {
        return CartItemDto.builder()
                .id(request.getId())
                .quantity(request.getQuantity())
                .build();
    }

    private CartItemResponse mapToResponse(CartItemDto dto) {
        return CartItemResponse.builder()
                .itemResponse(itemControllerMapper.toResponse(dto.getItemDto()))
                .quantity(dto.getQuantity())
                .build();
    }
}
