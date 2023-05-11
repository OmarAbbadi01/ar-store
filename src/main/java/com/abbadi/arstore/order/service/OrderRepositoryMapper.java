package com.abbadi.arstore.order.service;

import com.abbadi.arstore.common.generic.service.GenericRepositoryMapper;
import com.abbadi.arstore.customer.CustomerRepositoryMapper;
import com.abbadi.arstore.item.parent.ItemRepositoryMapper;
import com.abbadi.arstore.order.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderRepositoryMapper extends GenericRepositoryMapper<Long, Order, OrderDto> {

    private final CustomerRepositoryMapper customerMapper;

    private final ItemRepositoryMapper itemRepositoryMapper;

    @Override
    protected OrderDto mapToDto(Order entity) {
        return OrderDto.builder()
                .id(entity.getId())
                .creationDate(entity.getCreationDate())
                .approvalDate(entity.getApprovalDate())
                .deliveryDate(entity.getDeliveryDate())
                .orderStatus(entity.getOrderStatus())
                .discount(entity.getDiscount())
                .customerDto(customerMapper.toDto(entity.getCustomer()))
                .orderItemsDtos(entity.getOrdersItems()
                        .stream()
                        .map(orderItem -> OrderItemDto.builder()
                                .quantity(orderItem.getQuantity())
                                .pricePerPiece(orderItem.getPricePerPiece())
                                .itemDto(itemRepositoryMapper.toDto(orderItem.getItem()))
                                .build())
                        .toList()
                )
                .build();
    }

    @Override
    protected Order mapToEntity(OrderDto dto) {
        return Order.builder()
                .id(dto.getId())
                .creationDate(dto.getCreationDate())
                .approvalDate(dto.getApprovalDate())
                .deliveryDate(dto.getDeliveryDate())
                .orderStatus(dto.getOrderStatus())
                .discount(dto.getDiscount())
                .customer(customerMapper.toEntity(dto.getCustomerDto()))
                .ordersItems(dto.getOrderItemsDtos() != null ? dto.getOrderItemsDtos()
                        .stream()
                        .map(orderItemDto -> OrderItem.builder()
                                .id(OrderItemId.builder()
                                        .orderId(dto.getId())
                                        .itemId(orderItemDto.getItemDto().getId())
                                        .build())
                                .quantity(orderItemDto.getQuantity())
                                .pricePerPiece(orderItemDto.getPricePerPiece())
                                .item(itemRepositoryMapper.toEntity(orderItemDto.getItemDto()))
                                .build())
                        .toList() : null)
                .build();
    }
}
