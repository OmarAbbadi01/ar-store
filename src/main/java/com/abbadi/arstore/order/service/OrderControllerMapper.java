package com.abbadi.arstore.order.service;

import com.abbadi.arstore.common.generic.service.GenericControllerMapper;
import com.abbadi.arstore.customer.model.CustomerDto;
import com.abbadi.arstore.item.parent.ItemControllerMapper;
import com.abbadi.arstore.item.parent.model.ItemDto;
import com.abbadi.arstore.order.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderControllerMapper extends GenericControllerMapper<Long, OrderDto, OrderRequest, OrderResponse> {

    private final ItemControllerMapper itemControllerMapper;

    @Override
    protected OrderDto mapToDto(OrderRequest request) {
        return OrderDto.builder()
                .id(request.getId())
                .customerDto(CustomerDto.builder()
                        .id(request.getCustomerId())
                        .build())
                .orderItemsDtos(request.getItemsRequests()
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
                .build();
    }

    @Override
    protected OrderResponse mapToResponse(OrderDto dto) {
        return OrderResponse.builder()
                .id(dto.getId())
                .orderStatus(dto.getOrderStatus())
                .discount(dto.getDiscount())
                .totalPrice(dto.getTotalPrice())
                .orderItemResponses(dto.getOrderItemsDtos()
                        .stream()
                        .map(orderItemDto -> OrderItemResponse.builder()
                                .quantity(orderItemDto.getQuantity())
                                .price(orderItemDto.getPricePerPiece())
                                .itemResponse(itemControllerMapper.toResponse(orderItemDto.getItemDto()))
                                .build())
                        .toList())
                .build();
    }
}
