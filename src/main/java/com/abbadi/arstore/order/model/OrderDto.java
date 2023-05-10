package com.abbadi.arstore.order.model;

import com.abbadi.arstore.common.generic.model.GenericDto;
import com.abbadi.arstore.customer.model.CustomerDto;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class OrderDto implements GenericDto<Long> {

    private Long id;

    private LocalDate creationDate;

    private LocalDate approvalDate;

    private LocalDate deliveryDate;

    private OrderStatus orderStatus;

    private Double discount;

    private Double totalPrice;

    private CustomerDto customerDto;

    private List<OrderItemDto> orderItemsDtos;
}
