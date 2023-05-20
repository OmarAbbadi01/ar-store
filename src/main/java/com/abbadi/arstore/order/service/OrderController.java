package com.abbadi.arstore.order.service;

import com.abbadi.arstore.order.model.OrderRequest;
import com.abbadi.arstore.order.model.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

    private final OrderControllerMapper mapper;

    @Secured({"CUSTOMER", "STORE"})
    @GetMapping
    public ResponseEntity<List<OrderResponse>> getAllOrders() {
        Long customerId = (Long) SecurityContextHolder.getContext().getAuthentication().getDetails();
        List<OrderResponse> response = service.findAllCustomerOrders(customerId)
                .stream()
                .map(mapper::toResponse)
                .toList();
        return ResponseEntity.ok(response);
    }

    @Secured("CUSTOMER")
    @PostMapping
    public ResponseEntity<URI> createOrder(@RequestBody final OrderRequest request) {
        Long id = service.createOrder(mapper.toDto(request));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(uri).build();
    }

}
