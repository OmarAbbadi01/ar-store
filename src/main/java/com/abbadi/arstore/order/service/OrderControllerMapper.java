package com.abbadi.arstore.order.service;

import com.abbadi.arstore.customer.model.CustomerDto;
import com.abbadi.arstore.item.parent.ItemControllerMapper;
import com.abbadi.arstore.item.parent.model.ItemDto;
import com.abbadi.arstore.order.model.*;
import org.springframework.security.core.context.SecurityContextHolder;

public class OrderControllerMapper {

    public static OrderDto toDto(OrderRequest request) {
        return request != null ?
                OrderDto.builder()
                        .id(request.getId())
                        .customerDto(CustomerDto.builder()
                                .id((Long) SecurityContextHolder.getContext().getAuthentication().getDetails())
                                .build())
                        .orderItemsDtos(request.getOrderItems()
                                .stream()
                                .map(
                                        orderItemRequest -> OrderItemDto.builder()
                                                .id(OrderItemIdDto.builder()
                                                        .itemId(orderItemRequest.getItemId())
                                                        .build())
                                                .quantity(orderItemRequest.getQuantity())
                                                .itemDto(ItemDto.builder()
                                                        .id(orderItemRequest.getItemId())
                                                        .build())
                                                .build()
                                )
                                .toList())
                        .build() : null;
    }

    public static OrderResponse toResponse(OrderDto dto) {
        return dto != null ?
                OrderResponse.builder()
                        .id(dto.getId())
                        .orderStatus(dto.getOrderStatus())
                        .discount(dto.getDiscount())
                        .totalPrice(dto.getTotalPrice())
                        .orderItems(dto.getOrderItemsDtos()
                                .stream()
                                .map(orderItemDto -> OrderItemResponse.builder()
                                        .quantity(orderItemDto.getQuantity())
                                        .price(orderItemDto.getPricePerPiece())
                                        .item(ItemControllerMapper.toResponse(orderItemDto.getItemDto()))
                                        .build())
                                .toList())
                        .build() : null;
    }

}
