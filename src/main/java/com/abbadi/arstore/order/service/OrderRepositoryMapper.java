package com.abbadi.arstore.order.service;

import com.abbadi.arstore.common.generic.service.GenericRepositoryMapper;
import com.abbadi.arstore.customer.CustomerRepositoryMapper;
import com.abbadi.arstore.order.model.Order;
import com.abbadi.arstore.order.model.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderRepositoryMapper extends GenericRepositoryMapper<Long, Order, OrderDto> {

    private final CustomerRepositoryMapper customerMapper;

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
//                .ordersItems(dto.getOrderItemsDtos() != null ? dto.getOrderItemsDtos()
//                        .stream()
//                        .map(orderItemRepositoryMapper::toEntity)
//                        .toList() : null)
                .build();
    }
}
