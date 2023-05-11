package com.abbadi.arstore.order.service;

import com.abbadi.arstore.order.model.OrderDto;

public interface OrderRepository {

    OrderDto create(OrderDto dto);


}
