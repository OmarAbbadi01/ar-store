package com.abbadi.arstore.order.service;

import com.abbadi.arstore.order.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {

    private final OrderDao dao;

    private final OrderRepositoryMapper mapper;

    private final OrderItemDao orderItemDao;

    private final OrderItemRepositoryMapper orderItemRepositoryMapper;

    @Override
    public OrderDto create(OrderDto dto) {
        List<OrderItemDto> orderItemsDtos = dto.getOrderItemsDtos();
        dto.setOrderItemsDtos(null);
        Order order = dao.save(mapper.toEntity(dto));
        List<OrderItem> orderItems = orderItemsDtos
                .stream()
                .map(orderItemRepositoryMapper::toEntity)
                .toList();
        orderItems.forEach(orderItem -> {
            orderItem.setOrder(order);
            orderItem.getId().setOrderId(order.getId());
        });
        orderItems = orderItemDao.saveAll(orderItems);
        order.setOrdersItems(orderItems);
        dao.save(order);
        return mapper.toDto(order);
    }

    @Override
    public List<OrderDto> findAll() {
        return dao.findAll()
                .stream()
                .map(mapper::toDto)
                .peek(orderDto -> orderDto.setTotalPrice(dao.getOrderTotalPrice(orderDto.getId())))
                .toList();
    }

}
