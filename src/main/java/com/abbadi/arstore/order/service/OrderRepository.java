package com.abbadi.arstore.order.service;

import com.abbadi.arstore.order.model.OrderDto;

import java.util.List;

public interface OrderRepository {

    OrderDto create(OrderDto dto);

    List<OrderDto> findAllCustomerOrders(Long customerId);


}
