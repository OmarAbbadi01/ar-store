package com.abbadi.arstore.order.service;

import com.abbadi.arstore.common.validation.OnCreate;
import com.abbadi.arstore.order.model.OrderRequest;
import com.abbadi.arstore.order.model.OrderResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static com.abbadi.arstore.order.service.OrderControllerMapper.toDto;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
@Validated
public class OrderController {

    private final OrderService service;

    @Secured({"CUSTOMER", "STORE"})
    @GetMapping
    public ResponseEntity<List<OrderResponse>> getAllOrders() {
        Long customerId = (Long) SecurityContextHolder.getContext().getAuthentication().getDetails();
        List<OrderResponse> response = service.findAllCustomerOrders(customerId)
                .stream()
                .map(OrderControllerMapper::toResponse)
                .toList();
        return ResponseEntity.ok(response);
    }

    @Secured("CUSTOMER")
    @PostMapping
    @Validated(OnCreate.class)
    public ResponseEntity<URI> createOrder(@RequestBody @Valid final OrderRequest request) {
        Long id = service.createOrder(toDto(request));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(uri).build();
    }

}
