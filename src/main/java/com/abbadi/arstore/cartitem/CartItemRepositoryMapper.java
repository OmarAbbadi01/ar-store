package com.abbadi.arstore.cartitem;

import com.abbadi.arstore.cartitem.model.CartItem;
import com.abbadi.arstore.cartitem.model.CartItemDto;
import com.abbadi.arstore.cartitem.model.CartItemId;
import com.abbadi.arstore.common.generic.service.GenericRepositoryMapper;
import com.abbadi.arstore.customer.CustomerRepositoryMapper;
import com.abbadi.arstore.item.parent.ItemRepositoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CartItemRepositoryMapper extends GenericRepositoryMapper<CartItemId, CartItem, CartItemDto> {


    private final CustomerRepositoryMapper customerRepositoryMapper;

    private final ItemRepositoryMapper itemRepositoryMapper;

    @Override
    public CartItemDto mapToDto(CartItem entity) {
        return CartItemDto.builder()
                .id(entity.getId())
                .quantity(entity.getQuantity())
                .customerDto(customerRepositoryMapper.toDto(entity.getCustomer()))
                .itemDto(itemRepositoryMapper.toDto(entity.getItem()))
                .build();
    }

    @Override
    public CartItem mapToEntity(CartItemDto dto) {
        return CartItem.builder()
                .id(dto.getId())
                .quantity(dto.getQuantity())
                .customer(customerRepositoryMapper.toEntity(dto.getCustomerDto()))
                .item(itemRepositoryMapper.toEntity(dto.getItemDto()))
                .build();
    }
}
