//package com.abbadi.arstore.order.service;
//
//import com.abbadi.arstore.common.generic.service.GenericControllerMapper;
//import com.abbadi.arstore.customer.CustomerRepository;
//import com.abbadi.arstore.item.parent.ItemControllerMapper;
//import com.abbadi.arstore.item.parent.ItemRepository;
//import com.abbadi.arstore.order.model.OrderDto;
//import com.abbadi.arstore.order.model.OrderRequest;
//import com.abbadi.arstore.order.model.OrderResponse;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//
//@Component
//@RequiredArgsConstructor
//public class OrderControllerMapper extends GenericControllerMapper<Long, OrderDto, OrderRequest, OrderResponse> {
//
//    private final CustomerRepository customerRepository;
//
//    private final ItemRepository itemRepository;
//
//    private final ItemControllerMapper itemControllerMapper;
//
//    @Override
//    protected OrderDto mapToDto(OrderRequest request) {
//        return OrderDto.builder()
//                .id(request.getId())
//                .customerDto(cus)
//                .itemsIds(request.getItemsRequests())
//                .build();
//    }
//
//    @Override
//    protected OrderResponse mapToResponse(OrderDto dto) {
//        return OrderResponse.builder()
//                .id(dto.getId())
//                .orderStatus(dto.getOrderStatus())
//                .discount(dto.getDiscount())
//                .itemsResponse(dto.getOrderItemsDtos()
//                        .stream()
//                        .map(OrderItemDto::getItemDto)
//                        .map(itemControllerMapper::toResponse)
//                        .toList())
//                .build();
//    }
//}
