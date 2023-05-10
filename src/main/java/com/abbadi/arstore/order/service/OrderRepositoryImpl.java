package com.abbadi.arstore.order.service;

import com.abbadi.arstore.common.generic.service.GenericRepositoryImpl;
import com.abbadi.arstore.order.model.Order;
import com.abbadi.arstore.order.model.OrderDto;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryImpl extends GenericRepositoryImpl<Long, Order, OrderDto> implements OrderRepository {

    private final OrderDao dao;

    private final OrderRepositoryMapper mapper;

    public OrderRepositoryImpl(OrderDao dao, OrderRepositoryMapper mapper) {
        super(dao, mapper);
        this.dao = dao;
        this.mapper = mapper;
    }

}
