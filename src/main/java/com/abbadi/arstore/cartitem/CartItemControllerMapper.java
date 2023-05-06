package com.abbadi.arstore.cartitem;

import com.abbadi.arstore.cartitem.model.CartItemDto;
import com.abbadi.arstore.cartitem.model.CartItemId;
import com.abbadi.arstore.cartitem.model.CartItemRequest;
import com.abbadi.arstore.cartitem.model.CartItemResponse;
import com.abbadi.arstore.common.generic.service.GenericControllerMapper;
import com.abbadi.arstore.item.parent.ItemControllerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CartItemControllerMapper extends GenericControllerMapper<CartItemId, CartItemDto, CartItemRequest, CartItemResponse> {


    private final ItemControllerMapper itemControllerMapper;

    @Override
    public CartItemDto mapToDto(CartItemRequest request) {
        return CartItemDto.builder()
                .id(request.getId())
                .quantity(request.getQuantity())
                .build();
    }

    @Override
    public CartItemResponse mapToResponse(CartItemDto dto) {
        return CartItemResponse.builder()
                .itemResponse(itemControllerMapper.toResponse(dto.getItemDto()))
                .quantity(dto.getQuantity())
                .build();
    }
}
