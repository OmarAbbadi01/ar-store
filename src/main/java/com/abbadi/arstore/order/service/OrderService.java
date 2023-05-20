package com.abbadi.arstore.order.service;

import com.abbadi.arstore.order.model.OrderDto;

import java.util.List;

public interface OrderService {

    Long createOrder(OrderDto newOrderDto);

    List<OrderDto> findAllCustomerOrders(Long customerId);

    void approveOrder(Long id);

    void declineOrder(Long id);

    void cancelOrder(Long id);

    void moveOrderToTransite(Long id);

    void confirmOrderDelivery(Long id);

    // create order: controller: (customerId, itemId, quantity) - orderId
    //               service:

    // delete order: controller: (orderId) - 200

    // fetch order(s): controller: (customerId) - (order, all orderItems)

    // update order:
    // approve order
    // decline order
    // cancel order
    // move to transit
    // confirm delivery

}
