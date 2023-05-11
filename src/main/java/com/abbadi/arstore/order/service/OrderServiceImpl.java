package com.abbadi.arstore.order.service;

import com.abbadi.arstore.cartitem.CartItemRepository;
import com.abbadi.arstore.cartitem.model.CartItemId;
import com.abbadi.arstore.common.exception.ArStoreException;
import com.abbadi.arstore.common.exception.ArStoreExceptionMessages;
import com.abbadi.arstore.customer.CustomerRepository;
import com.abbadi.arstore.item.parent.ItemRepository;
import com.abbadi.arstore.order.model.OrderDto;
import com.abbadi.arstore.order.model.OrderItemIdDto;
import com.abbadi.arstore.order.model.OrderStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final CustomerRepository customerRepository;

    private final ItemRepository itemRepository;

    private final CartItemRepository cartItemRepository;

    @Override
    public Long createOrder(OrderDto newOrderDto) {
        Long customerId = newOrderDto.getCustomerDto().getId();
        validateCustomer(customerId);
        newOrderDto.getOrderItemsDtos()
                .forEach(orderItemDto ->
                        validateItem(orderItemDto.getId().getItemId()));
        newOrderDto.getOrderItemsDtos()
                .forEach(orderItemDto ->
                        validateItemsQuantity(orderItemDto.getId().getItemId()));
//        newOrderDto.getOrderItemsDtos().forEach(orderItemDto -> validateItemsInCart(orderItemDto.getItemDto().getId(), customerId));

        newOrderDto.setCreationDate(LocalDate.now());
        newOrderDto.setOrderStatus(OrderStatus.PENDING_APPROVAL);
        newOrderDto.setDiscount(0D); // TODO: should be derived
        newOrderDto.setCustomerDto(customerRepository.findById(customerId));
//        newOrderDto.setTotalPrice(newOrderDto.getOrderItemsDtos().stream()
//                .mapToDouble(orderItemDto -> itemRepository.findById(orderItemDto.getItemDto().getId()).getPrice())
//                .sum());
        newOrderDto.getOrderItemsDtos()
                .forEach(orderItemDto -> {
                    orderItemDto
                            .setItemDto(itemRepository.findById(orderItemDto.getItemDto().getId()));
                    orderItemDto
                            .setPricePerPiece(itemRepository.findById(orderItemDto.getItemDto().getId()).getPrice());
                    orderItemDto.setId(OrderItemIdDto.builder()
                            .itemId(orderItemDto.getItemDto().getId())
                            .build());
                });

        return orderRepository.create(newOrderDto).getId();
    }

    @Override
    public List<OrderDto> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public void approveOrder(Long id) {

    }

    @Override
    public void declineOrder(Long id) {

    }

    @Override
    public void cancelOrder(Long id) {

    }

    @Override
    public void moveOrderToTransite(Long id) {

    }

    @Override
    public void confirmOrderDelivery(Long id) {

    }

    private void validateCustomer(Long customerId) {
        if (!customerRepository.existsById(customerId)) {
            throw ArStoreException.builder()
                    .message(ArStoreExceptionMessages.ID_NOT_FOUND)
                    .params(Collections.singletonList(customerId))
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

    private void validateItem(Long itemId) {
        if (!itemRepository.existsById(itemId)) {
            throw ArStoreException.builder()
                    .message(ArStoreExceptionMessages.ID_NOT_FOUND)
                    .params(Collections.singletonList(itemId))
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
    }

    private void validateItemsInCart(Long itemId, Long customerId) {
        CartItemId cartItemId = CartItemId.builder()
                .itemId(itemId)
                .customerId(customerId)
                .build();
        if (!cartItemRepository.existsById(cartItemId)) {
            throw ArStoreException.builder()
                    .message("Item not in cart")
                    .params(Collections.singletonList(itemId))
                    .status(HttpStatus.BAD_REQUEST)
                    .build();
        }
    }

    private void validateItemsQuantity(Long itemId) {
        // TODO: check quantity from inventory
    }
}
