package com.abbadi.arstore.order.model;

import com.abbadi.arstore.common.generic.model.GenericRequest;
import lombok.Value;

import java.util.List;

@Value
public class OrderRequest implements GenericRequest<Long> {

    Long id;

    Long customerId; // TODO: remove

    List<OrderItemRequest> itemsRequests;

}
