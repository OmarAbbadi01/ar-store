package com.abbadi.arstore.order.service;

import com.abbadi.arstore.order.model.OrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

//    private final OrderControllerMapper mapper;

    @PostMapping
    public ResponseEntity<URI> createOrder(@RequestBody final OrderRequest request) {
//        Long id = service.createOrder(mapper.toDto(request));
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(id)
//                .toUri();
//        return ResponseEntity.created(uri).build();
        return null;
    }

}
